package com.killpekeinside.logic.service;

import com.killpekeinside.data.dto.IDto;
import com.killpekeinside.logic.persistence.IDao;

/**
 * Created by Raman_Susla on 05.04.2015 1:10.
 */
public interface IService<T extends IDto> {
    <T extends IDao> T getDao();
}
