package com.epam.rs.patterns.facade;

import com.epam.rs.data.Record;

import java.util.List;

/**
 * Created by catmo_000 on 12/20/2015.
 */
public class Facade {
    private static final MemoryStore memoryStore = new MemoryStore();
    private static final XmlStore xmlStore = new XmlStore();

    public enum ConnectionType{
        MEMORY, XML;
    }

    public static List getAllRecords(ConnectionType type) {
        switch (type){
            case MEMORY:return memoryStore.getAll();
            case XML:return xmlStore.getAll();
            default: throw new RuntimeException("Unsupported type");
        }
    }

    public static void addRecord(Record object, ConnectionType type) {
        switch (type){
            case MEMORY:
                memoryStore.add(object);
                return;
            case XML:
                xmlStore.add(object);
                xmlStore.save();
                return;
            default: throw new RuntimeException("Unsupported type");
        }
    }

    public static void removeRecord(long id, ConnectionType type) {
        switch (type){
            case MEMORY:
                memoryStore.remove(id);
                return;
            case XML:
                xmlStore.remove(id);
                xmlStore.save();
                return;
            default: throw new RuntimeException("Unsupported type");
        }
    }
}
