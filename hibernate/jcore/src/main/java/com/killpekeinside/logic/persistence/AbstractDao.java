package com.killpekeinside.logic.persistence;

import com.killpekeinside.data.entity.IEntity;
import lombok.Getter;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created by Raman_Susla on 31.03.2015 23:51.
 */
public abstract class AbstractDao<IdType, EType extends IEntity<IdType>> implements IDao<IdType,EType> {
    @PersistenceContext
    @Getter
    private EntityManager entityManager;


}
