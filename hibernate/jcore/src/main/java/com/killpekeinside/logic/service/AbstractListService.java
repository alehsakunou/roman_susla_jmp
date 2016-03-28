package com.killpekeinside.logic.service;

import com.killpekeinside.data.dto.IDto;
import com.killpekeinside.data.entity.IEntity;
import com.killpekeinside.exceptions.ServiceException;
import com.killpekeinside.logic.persistence.IListDao;

import java.util.Collection;
import java.util.List;

/**
 * Created by Raman_Susla on 05.04.2015 23:34.
 */
public abstract class AbstractListService<TDto extends IDto, TEntity extends IEntity<Long>>
        extends AbstractService<TDto,TEntity>
        implements IListService<TDto> {


    public abstract IListDao<Long,TEntity> getDao();

    @Override
    public List<TDto> getAll() {
        return convertEntitiesListToDtoList(getDao().getAll());
    }

    public abstract Class<TEntity> getEntityType();

    public abstract Class<TDto> getDtoType();

    protected List<TEntity> convertDtoListToEntitiesList(Collection<TDto> dtoList) throws ServiceException {
        return convertDtoListToEntitiesList(dtoList, getEntityType());
    }

    protected List<TDto> convertEntitiesListToDtoList(Collection<TEntity> entities) throws ServiceException {
        return convertEntitiesListToDtoList(entities, getDtoType());
    }

    protected TEntity convertDtoToEntity(TDto dto) throws ServiceException {
        return convertDtoToEntity(dto, getEntityType());
    }

    protected TDto convertEntityToDto(TEntity entity) throws ServiceException {
        return convertEntityToDto(entity, getDtoType());
    }
}
