package com.killpekeinside.logic.service.user;

import com.killpekeinside.data.dto.RoleDto;
import com.killpekeinside.data.dto.UserDto;
import com.killpekeinside.data.dto.UserSystemDto;
import com.killpekeinside.data.entity.UserEntity;
import com.killpekeinside.exceptions.ServiceException;
import com.killpekeinside.logic.persistence.user.IUserDao;
import com.killpekeinside.logic.service.AbstractCrudService;
import com.killpekeinside.util.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

/**
 * Created by Raman_Susla1 on 6/5/2015.
 */
@Service
public class UserService extends AbstractCrudService<UserSystemDto, UserEntity> implements IUserService
{

    @Autowired
    private IUserDao userDao;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Override
    public IUserDao getDao()
    {
        return userDao;
    }

    @Override
    public Class<UserEntity> getEntityType()
    {
        return UserEntity.class;
    }

    @Override
    public Class<UserSystemDto> getDtoType()
    {
        return UserSystemDto.class;
    }

    @Override
    public UserSystemDto findByUid(String uid) throws ServiceException
    {
        return convertEntityToDto(getDao().findByUid(uid));
    }

    @Override
    public UserSystemDto findByEmail(String email) throws ServiceException
    {
        return convertEntityToDto(getDao().findByEmail(email));
    }
}
