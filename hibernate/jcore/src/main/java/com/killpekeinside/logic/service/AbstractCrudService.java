package com.killpekeinside.logic.service;

import com.killpekeinside.data.dto.IDto;
import com.killpekeinside.data.entity.IEntity;
import com.killpekeinside.exceptions.DaoException;
import com.killpekeinside.exceptions.ServiceException;
import com.killpekeinside.logic.persistence.ICrudDao;

/**
 * Created by Raman_Susla1 on 6/5/2015.
 */
public abstract class AbstractCrudService<TDto extends IDto, TEntity extends IEntity<Long>> extends AbstractListService<TDto,TEntity> implements ICrudService<TDto> {

    public abstract ICrudDao<Long,TEntity> getDao();

    @Override
    public TDto create(TDto dto) throws ServiceException {
        TDto newDto;
        try{
            TEntity entity=convertDtoToEntity(dto);
            entity = getDao().create(entity);
            newDto=convertEntityToDto(entity);
        }catch(DaoException e){
            throw new ServiceException("Can't create Dto",e);
        }

        return newDto;
    }

    @Override
    public TDto update(TDto dto) throws ServiceException {
        TDto updatedDto;
        try{
            TEntity entity=convertDtoToEntity(dto);
            entity = getDao().update(entity);
            updatedDto=convertEntityToDto(entity);
        }catch(DaoException e){
            throw new ServiceException("Can't update Dto",e);
        }

        return updatedDto;
    }

    @Override
    public void remove(TDto dto) throws ServiceException {
        try{
            TEntity entity=convertDtoToEntity(dto);
            getDao().remove(entity);
        }catch(DaoException e){
            throw new ServiceException("Can't remove Dto",e);
        }
    }

}
