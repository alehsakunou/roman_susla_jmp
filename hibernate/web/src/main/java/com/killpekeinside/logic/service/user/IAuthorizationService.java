package com.killpekeinside.logic.service.user;

import com.killpekeinside.data.dto.UserAuthDto;
import com.killpekeinside.logic.service.IService;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
 * Created by Raman_Susla1 on 6/12/2015.
 */
public interface IAuthorizationService extends IService<UserAuthDto>, UserDetailsService {
}
