package com.killpekeinside.controller;

import com.killpekeinside.data.dto.UserAuthDto;
import com.killpekeinside.data.dto.UserDto;
import com.killpekeinside.data.dto.UserSystemDto;
import com.killpekeinside.data.mapper.IMapper;
import com.killpekeinside.logic.service.user.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.social.connect.Connection;
import org.springframework.social.connect.UserProfile;
import org.springframework.social.connect.web.ProviderSignInUtils;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.WebRequest;

@Controller
public class SignUpController {

	@Autowired
	private ProviderSignInUtils providerSignInUtils;

	@Autowired
	private IUserService userService;

	@Autowired
	private IMapper mapper;


	@RequestMapping (value = "/signup", method = RequestMethod.GET)
	@Transactional
	public String redirectRequestToRegistrationPage(WebRequest request, ModelMap modelMap) {
		Connection<?> connection = providerSignInUtils.getConnectionFromSession(request);
		UserProfile userProfile = connection.fetchUserProfile();

		UserDto userSocial = mapper.map(userProfile,UserDto.class);

		modelMap.put("user", userSocial);

		return "signup";
	}

	@RequestMapping (value = "/signup", method = RequestMethod.POST)
	@Transactional
	public String registrationUser(@ModelAttribute UserSystemDto userRequest, WebRequest request) throws Exception {
		try {

			userRequest = userService.create(userRequest);
			providerSignInUtils.doPostSignUp(userRequest.getEmail(), request);

			UserAuthDto userAuthDto = mapper.map(userRequest,UserAuthDto.class);

			Authentication authentication = new UsernamePasswordAuthenticationToken(userAuthDto, null, userAuthDto.getAuthorities());
			SecurityContextHolder.getContext().setAuthentication(authentication);
			return "redirect:/";
		} catch (Exception e) {
			return String.format("redirect:/error?message=%s", e.getMessage());
		}
	}
}
