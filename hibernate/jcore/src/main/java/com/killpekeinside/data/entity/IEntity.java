package com.killpekeinside.data.entity;

import java.io.Serializable;

/**
 * Created by Raman_Susla on 31.03.2015 23:53.
 */
public interface IEntity<T> extends Serializable {
    T getId();
}
