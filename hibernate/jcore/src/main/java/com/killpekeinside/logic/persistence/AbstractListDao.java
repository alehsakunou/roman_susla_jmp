package com.killpekeinside.logic.persistence;

import com.killpekeinside.data.entity.IEntity;
import com.killpekeinside.logic.IList;
import com.killpekeinside.util.Pair;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 * Created by Raman_Susla on 31.03.2015 23:52.
 */
public abstract class AbstractListDao<IdType, EType extends IEntity<IdType>> extends AbstractDao<IdType, EType> implements IList<EType> {
    private static final String LIST_QUERY_CONST = "from %s";
    private final String listQuery;
    {
        listQuery = String.format(LIST_QUERY_CONST, getEntityClass().getSimpleName());
    }

    protected abstract Class<EType> getEntityClass();
    @Transactional(readOnly = true)
    public List<EType> getAll() {
        TypedQuery<EType> query = getEntityManager().createQuery(listQuery, getEntityClass());
        return query.getResultList();
    }

    public EType find(IdType primaryKey) {
        return this.getEntityManager().find(getEntityClass(), primaryKey);
    }

    protected EType findByNamedQuery(String queryName, Pair<String, ?>... parameters){
        Query query = getEntityManager().createNamedQuery(queryName);
        for (Pair<String, ?> parameter: parameters)
        {
            query.setParameter(parameter.getFirst(), parameter.getSecond());
        }
        List results=query.getResultList();
        return results.size()>0?(EType)results.get(0):null;
    }
}
