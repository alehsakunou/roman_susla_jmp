package com.killpekeinside.logic;

import com.killpekeinside.exceptions.VException;

/**
 * Created by Raman_Susla on 01.04.2015 0:31.
 */
public interface ICrud<T> extends IList<T> {
    T create(T obj) throws VException;

    T update(T obj) throws VException;

    void remove(T obj) throws VException;

}
