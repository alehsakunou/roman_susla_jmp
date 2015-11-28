package com.epam.rs;

import com.epam.rs.duck.Duck;
import com.epam.rs.duck.LiveDuck;
import com.epam.rs.logistics.Direction;
import com.epam.rs.logistics.Zone;
import com.epam.rs.util.Utils;
import org.apache.log4j.Logger;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Raman_Susla1 on 11/28/2015.
 */
public class Main
{
    private final static Logger LOGGER = Logger.getLogger(Main.class);

    public static void main(String[] args)
    {
        try
        {
            char[][] areaMap = Utils.readAreaMap(Main.class.getClassLoader().getResource("default.map").getFile());
            Utils.outputAreaMap(areaMap, -1, -1);
            Duck duck = new LiveDuck(Zone.FLATLAND);
        }
        catch (FileNotFoundException e)
        {
            LOGGER.error(e);
        }
    }
}
