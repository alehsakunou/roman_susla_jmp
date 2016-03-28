package com.killpekeinside.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.connect.Connection;
import org.springframework.social.connect.ConnectionRepository;
import org.springframework.social.linkedin.api.LinkedIn;
import org.springframework.social.linkedin.api.NetworkStatistics;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.security.Principal;

@Controller
public class LoginController {

	@Autowired
	private LinkedIn linkedIn;

	@Autowired
	private ConnectionRepository connectionRepository;

	@RequestMapping (value = "/login")
	public String login() {
		return "index";
	}


	@RequestMapping(value="/linkedin/connections", method= RequestMethod.GET)
	public String connections(Model model) {
		NetworkStatistics statistics = linkedIn.connectionOperations().getNetworkStatistics();

		model.addAttribute("firstDegreeCount", statistics.getFirstDegreeCount());
		model.addAttribute("secondDegreeCount", statistics.getSecondDegreeCount());
		model.addAttribute("connections", linkedIn.connectionOperations().getConnections());
		return "linkedin/connections";
	}



	@RequestMapping(value="/linkedin", method=RequestMethod.GET)
	public String home(Principal currentUser, Model model) {
		Connection<LinkedIn> connection = connectionRepository.findPrimaryConnection(LinkedIn.class);
		if (connection == null) {
			return "redirect:/connect/linkedin";
		}
		model.addAttribute("profile", connection.getApi().profileOperations().getUserProfileFull());
		return "linkedin/profile";
	}

	@RequestMapping(value="/github/connections", method= RequestMethod.GET)
	public String connectionsG(Model model) {
		NetworkStatistics statistics = linkedIn.connectionOperations().getNetworkStatistics();
		model.addAttribute("firstDegreeCount", statistics.getFirstDegreeCount());
		model.addAttribute("secondDegreeCount", statistics.getSecondDegreeCount());
		model.addAttribute("connections", linkedIn.connectionOperations().getConnections());
		return "github/connections";
	}



	@RequestMapping(value="/github", method=RequestMethod.GET)
	public String homeG(Principal currentUser, Model model) {
		Connection<LinkedIn> connection = connectionRepository.findPrimaryConnection(LinkedIn.class);
		if (connection == null) {
			return "redirect:/connect/github";
		}
		model.addAttribute("profile", connection.getApi().profileOperations().getUserProfileFull());
		return "github/profile";
	}
}
