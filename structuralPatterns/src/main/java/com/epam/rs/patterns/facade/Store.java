package com.epam.rs.patterns.facade;

import java.util.List;

/**
 * Created by catmo_000 on 12/20/2015.
 */
public interface Store<T> {
    List<T> getAll();
    void add(T object);
    void remove(long id);
}
