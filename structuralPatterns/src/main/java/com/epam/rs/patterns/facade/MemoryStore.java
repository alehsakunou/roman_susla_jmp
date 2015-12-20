package com.epam.rs.patterns.facade;

import com.epam.rs.data.Record;

import java.util.*;

/**
 * Created by catmo_000 on 12/20/2015.
 */
public class MemoryStore implements Store<Record> {
    private final Set<Record> records;
    public MemoryStore() {
        records = new HashSet<>();}
    public MemoryStore(boolean initRandom) {
        this();
        if(initRandom)
        {
            Random random = new Random();
            records.add(new Record(random.nextLong(),"m1"));
            records.add(new Record(random.nextLong(),"m2"));
            records.add(new Record(random.nextLong(),"m3"));
            records.add(new Record(random.nextLong(),"m4"));
            records.add(new Record(random.nextLong(),"m5"));
            records.add(new Record(random.nextLong(),"m6"));
            records.add(new Record(random.nextLong(),"m7"));
        }
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
