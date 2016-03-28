package com.killpekeinside.logic.persistence;

import com.killpekeinside.data.entity.IEntity;
import com.killpekeinside.logic.ICrud;

public interface ICrudDao<IdType,EType extends IEntity<IdType>>  extends IListDao<IdType,EType>,ICrud<EType> {
}
