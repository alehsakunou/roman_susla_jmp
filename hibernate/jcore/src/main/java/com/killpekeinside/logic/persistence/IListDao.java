package com.killpekeinside.logic.persistence;

import com.killpekeinside.data.entity.IEntity;
import com.killpekeinside.logic.IList;

/**
 * Created by Raman_Susla1 on 6/8/2015.
 */
public interface IListDao<IdType,EType extends IEntity<IdType>>  extends IDao<IdType,EType>,IList<EType> {
}
