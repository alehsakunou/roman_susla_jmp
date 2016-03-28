package com.killpekeinside.logic.service.role;

import com.killpekeinside.data.dto.RoleDto;
import com.killpekeinside.data.entity.RoleEntity;
import com.killpekeinside.logic.persistence.ICrudDao;
import com.killpekeinside.logic.persistence.role.IRoleDao;
import com.killpekeinside.logic.service.AbstractCrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Raman_Susla1 on 6/8/2015.
 */
@Service
public class RoleService extends AbstractCrudService<RoleDto,RoleEntity> implements IRoleService {
    @Autowired
    private IRoleDao roleDao;

    @Override
    public ICrudDao<Long, RoleEntity> getDao() {
        return roleDao;
    }

    @Override
    public Class<RoleEntity> getEntityType() {
        return RoleEntity.class;
    }

    @Override
    public Class<RoleDto> getDtoType() {
        return RoleDto.class;
    }
}
