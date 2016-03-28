package com.killpekeinside.logic.service;

import com.killpekeinside.data.dto.IDto;
import com.killpekeinside.logic.IList;

/**
 * Created by Raman_Susla1 on 6/8/2015.
 */
public interface IListService<T extends IDto> extends IService<T>, IList<T> {
}
