package com.killpekeinside.logic.service.user;

import com.killpekeinside.data.dto.UserDto;
import com.killpekeinside.data.dto.UserSystemDto;
import com.killpekeinside.exceptions.ServiceException;
import com.killpekeinside.logic.service.ICrudService;

/**
 * Created by Raman_Susla1 on 6/5/2015.
 */
public interface IUserService extends ICrudService<UserSystemDto> {
    UserSystemDto findByUid(String uid) throws ServiceException;
    UserSystemDto findByEmail(String email) throws ServiceException;
}
