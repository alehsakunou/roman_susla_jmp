package com.epam.rs.patterns.adapter;

/**
 * Created by catmo_000 on 12/21/2015.
 */
public interface Mover<T> {
    void moveTo(T object);
}
