package com.killpekeinside.logic.persistence.user;

import com.killpekeinside.data.entity.UserEntity;
import com.killpekeinside.exceptions.DaoException;
import com.killpekeinside.logic.persistence.AbstractCrudDao;
import com.killpekeinside.util.Pair;
import org.springframework.stereotype.Repository;

/**
 * Created by Raman_Susla on 10.04.2015 21:02.
 */
@Repository
public class UserDao extends AbstractCrudDao<Long, UserEntity> implements IUserDao {

    @Override
    @SuppressWarnings("unchecked")
    protected Class getEntityClass() {
        return UserEntity.class;
    }

    @Override
    public UserEntity findByUid(String uid) throws DaoException {
        return findByNamedQuery(UserEntity.FIND_BY_UID, new Pair<>("uid", uid));
    }

    @Override
    public UserEntity findByEmail(String email) throws DaoException {
        return findByNamedQuery(UserEntity.FIND_BY_EMAIL, new Pair<>("email", email));
    }


}

