package com.epam.rs.patterns.adapter;

import com.epam.rs.data.Record;

/**
 * Created by catmo_000 on 12/21/2015.
 */
public class ListAdapter implements Mover<Record>{
    private final MoveSupportedList list;

    public ListAdapter(MoveSupportedList list) {this.list = list;}

    @Override
    public void moveTo(Record object) {
        list.addRecord(object);
    }
}
