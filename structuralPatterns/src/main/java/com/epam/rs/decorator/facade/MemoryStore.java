package com.epam.rs.decorator.facade;

import com.epam.rs.data.Record;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by catmo_000 on 12/20/2015.
 */
public class MemoryStore implements Store<Record> {
    private final Set<Record> records;

    public MemoryStore() {
        records = new HashSet<>();
    }

    public List<Record> getAll() {
        final List<Record> list = new ArrayList<>(records.size());
        records.stream().forEach(x-> list.add(new Record(x)));
        return list;
    }

    public void add(Record object) {
        records.add(object);
    }

    public void remove(long id) {
        records.removeIf(x->x.getId()==id);
    }
}
