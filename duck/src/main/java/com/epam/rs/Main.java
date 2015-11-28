package com.epam.rs;

import com.epam.rs.duck.Duck;
import com.epam.rs.duck.ToyDuck;
import com.epam.rs.logistics.Direction;
import com.epam.rs.logistics.Zone;
import com.epam.rs.util.Utils;
import org.apache.log4j.Logger;

import java.io.FileNotFoundException;

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
            Zone[][] areaMap = Utils.readAreaMap(Main.class.getClassLoader().getResource("default.map").getFile());
            Utils.outputAreaMap(areaMap, 5, 5);
            Duck duck = new ToyDuck(Zone.FLATLAND);
            duck.tryAction(Direction.DOWN, Zone.FLATLAND);
            duck.tryAction(Direction.DOWN, Zone.FLATLAND);
            duck.tryAction(Direction.DOWN, Zone.FLATLAND);
            duck.tryAction(Direction.DOWN, Zone.WATER);
            duck.tryAction(Direction.DOWN, Zone.WATER);
            duck.tryAction(Direction.DOWN, Zone.FLATLAND);
            duck.tryAction(Direction.DOWN, Zone.FLATLAND);
            duck.tryAction(Direction.DOWN, Zone.FLATLAND);
            duck.tryAction(Direction.DOWN, Zone.FLATLAND);
            duck.tryAction(Direction.DOWN, Zone.WATER);
            duck.tryAction(Direction.DOWN, Zone.WATER);
            duck.tryAction(Direction.DOWN, Zone.WATER);
            duck.tryAction(Direction.DOWN, Zone.WATER);
            duck.tryAction(Direction.DOWN, Zone.FLATLAND);
            duck.tryAction(Direction.DOWN, Zone.FLATLAND);
            duck.tryAction(Direction.DOWN, Zone.FLATLAND);
            duck.tryAction(Direction.DOWN, Zone.FLATLAND);
            duck.tryAction(Direction.DOWN, Zone.WATER);
            duck.tryAction(Direction.DOWN, Zone.WATER);
            duck.tryAction(Direction.DOWN, Zone.WATER);
            duck.tryAction(Direction.DOWN, Zone.WATER);
            duck.tryAction(Direction.DOWN, Zone.WALL);
            duck.tryAction(Direction.DOWN, Zone.WALL);
            duck.tryAction(Direction.DOWN, Zone.WALL);

        }
        catch (FileNotFoundException e)
        {
            LOGGER.error(e);
        }
    }
}
