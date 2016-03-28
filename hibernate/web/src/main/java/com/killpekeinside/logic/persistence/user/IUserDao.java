package com.killpekeinside.logic.persistence.user;

import com.killpekeinside.data.entity.UserEntity;
import com.killpekeinside.exceptions.DaoException;
import com.killpekeinside.logic.persistence.ICrudDao;

public interface IUserDao extends ICrudDao<Long,UserEntity> {
    UserEntity findByUid(String uid) throws DaoException;
    UserEntity findByEmail(String email) throws DaoException;
}
