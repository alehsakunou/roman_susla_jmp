package com.epam.rs.logistics;

/**
 * Created by Raman_Susla1 on 11/28/2015.
 */
public enum Zone
{
    WATER('w'), WALL('1'), FLATLAND('0');
    private final char id;

    Zone(char id)
    {
        this.id = id;
    }


    public char getId()
    {
        return id;
    }
}
