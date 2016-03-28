package com.killpekeinside.logic.service.user;

import com.killpekeinside.data.dto.UserAuthDto;
import com.killpekeinside.data.entity.UserEntity;
import com.killpekeinside.exceptions.ServiceException;
import com.killpekeinside.logic.persistence.user.IUserDao;
import com.killpekeinside.logic.service.AbstractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * Created by Raman_Susla1 on 6/9/2015.
 */
@Service
public class AuthorizationService extends AbstractService<UserAuthDto, UserEntity> implements IAuthorizationService {
    @Autowired
    protected IUserDao userDao;

    @Override
    public IUserDao getDao() {
        return userDao;
    }

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String uid)
            throws UsernameNotFoundException {
        UserEntity entity;
        UserAuthDto dto;
        try {
            entity = getDao().findByUid(uid);
            if (entity == null)
                throw new UsernameNotFoundException(String.format("User with username %s not found", uid));
            dto = new UserAuthDto();
            getMapper().map(entity, dto);
        } catch (ServiceException e) {
            throw new UsernameNotFoundException(String.format("Can't get user %s", uid));
        }

        return dto;
    }
}
