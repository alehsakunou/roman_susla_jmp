package com.killpekeinside.logic.service;

import com.killpekeinside.data.dto.IDto;
import com.killpekeinside.data.entity.IEntity;
import com.killpekeinside.data.mapper.AbstractOrikaMapper;
import com.killpekeinside.data.mapper.IMapper;
import com.killpekeinside.exceptions.ServiceException;
import com.killpekeinside.logic.persistence.IDao;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by Raman_Susla on 05.04.2015 1:08.
 */
public abstract class AbstractService<TDto extends IDto, TEntity extends IEntity<Long>> implements IService<TDto> {
    @Autowired
    @Getter protected IMapper mapper;

    public abstract IDao<Long,TEntity> getDao();

    protected <EntityType extends IEntity, DtoType extends IDto> EntityType convertDtoToEntity(
            DtoType dto, Class<EntityType> entityTypeClass
    ) throws ServiceException {

        if (dto != null) {
            return mapper.map(dto, entityTypeClass);
        }
        return null;
    }

    protected <EntityType extends IEntity, DtoType extends IDto> DtoType convertEntityToDto(
            EntityType entity,
            Class<DtoType> dtoTypeClass
    ) throws ServiceException {

        if (entity != null) {
            return mapper.map(entity, dtoTypeClass);
        }
        return null;
    }

    protected <EntityType extends IEntity, DtoType extends IDto> List<EntityType> convertDtoListToEntitiesList(
            Collection<DtoType> dtoList,
            Class<EntityType> entityTypeClass
    ) throws ServiceException {

        List<EntityType> entities = new ArrayList<>(dtoList.size());
        for (DtoType dto : dtoList) {
            entities.add(convertDtoToEntity(dto, entityTypeClass));
        }
        return entities;
    }

    protected <EntityType extends IEntity, DtoType extends IDto> List<DtoType> convertEntitiesListToDtoList(
            Collection<EntityType> entities,
            Class<DtoType> dtoTypeClass
    ) throws ServiceException {

        List<DtoType> dtoList = new ArrayList<>(entities.size());
        for (EntityType entity : entities) {
            dtoList.add(convertEntityToDto(entity, dtoTypeClass));
        }
        return dtoList;
    }
}
