package com.killpekeinside.logic.persistence.role;

import com.killpekeinside.data.entity.RoleEntity;
import com.killpekeinside.logic.persistence.AbstractCrudDao;
import org.springframework.stereotype.Repository;

/**
 * Created by Raman_Susla1 on 6/8/2015.
 */
@Repository
public class RoleDao extends AbstractCrudDao<Long,RoleEntity> implements IRoleDao {

    @Override
    protected Class<RoleEntity> getEntityClass() {
        return RoleEntity.class;
    }
}
