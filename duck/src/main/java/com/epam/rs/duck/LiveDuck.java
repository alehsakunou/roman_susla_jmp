package com.epam.rs.duck;

import com.epam.rs.logistics.Direction;
import com.epam.rs.logistics.Reaction;
import com.epam.rs.logistics.Zone;

/**
 * Created by Raman_Susla1 on 11/25/2015.
 */
public class LiveDuck extends Duck
{
    private static final double STEP_SIZE = 1;
    public void fly() { logger.info("I fly!"); }



    @Override
    protected double getStepSize() { return STEP_SIZE; }

    @Override
    protected void howToOvercome(Zone zone)
    {
        if (isHungry())
        {
            if(zone.equals(Zone.FLATLAND))
            {
                walk();
                return;
            }
            if(zone.equals(Zone.WATER))
            {
                swim();
                return;
            }
        }
        fly();
    }

    @Override
    protected Reaction getAvailability(Zone zone)
    {
        if(zone.equals(Zone.WALL))
            return Reaction.CAN_NOT;
        return Reaction.CAN;
    }
}
