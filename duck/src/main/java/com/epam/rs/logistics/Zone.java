package com.epam.rs.logistics;

/**
 * Created by Raman_Susla1 on 11/28/2015.
 */
public enum Zone {
    WATER('W'), WALL('1'), FLATLAND('0'), FINISH('X'), START('I');
    private final char id;

    Zone(char id) {
        this.id = id;
    }

    public char getId() {
        return id;
    }

    public static Zone getZone(char value) {
        for (Zone zone : values())
            if (zone.getId() == value) return zone;
        throw new IllegalArgumentException();
    }
}
