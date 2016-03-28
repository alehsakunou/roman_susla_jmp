package com.killpekeinside.logic.persistence;

import com.killpekeinside.data.entity.IEntity;
import com.killpekeinside.exceptions.DaoException;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Raman_Susla on 01.04.2015 0:24.
 */
public abstract class AbstractCrudDao<IdType,EType extends IEntity<IdType>> extends AbstractListDao<IdType,EType> implements ICrudDao<IdType,EType> {
    @Override
    @Transactional(propagation = Propagation.MANDATORY)
    public EType create(EType entity) throws DaoException {
        try {
            getEntityManager().persist(entity);
            return entity;
        } catch (Exception exc) {
            throw new DaoException(exc);
        }
    }

    @Override
    @Transactional(propagation = Propagation.MANDATORY)
    public EType update(EType entity) throws DaoException {
        try {
            return getEntityManager().merge(entity);
        } catch (Exception exc) {
            throw new DaoException(exc);
        }
    }

    @Override
    @Transactional
    public void remove(EType entity) throws DaoException {
        try {
            getEntityManager().remove(entity);
        } catch (Exception exc) {
            throw new DaoException(exc);
        }
    }
}
