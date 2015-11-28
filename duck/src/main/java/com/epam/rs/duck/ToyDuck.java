package com.epam.rs.duck;

import com.epam.rs.logistics.Direction;
import com.epam.rs.logistics.Reaction;
import com.epam.rs.logistics.Zone;

/**
 * Created by Raman_Susla1 on 11/25/2015.
 */
public class ToyDuck extends Duck
{
    private static final double STEP_SIZE = 0.5;

    public void flitter() { logger.info("I flit"); }

    private boolean isOn = true;

    @Override
    public void walk()
    {
        super.walk();
        flitter();
    }


    @Override
    public void charge(){
        super.charge();
        isOn = true;
    }

    @Override
    protected double getStepSize() { return STEP_SIZE; }

    @Override
    protected void howToOvercome(Zone zone)
    {
        if(isOn){
            if(zone.equals(Zone.FLATLAND))
            {
                walk();
                return;
            }
            if(zone.equals(Zone.WATER))
            {
                swim();
            }
        }
    }

    @Override
    protected Reaction getAvailability(Zone zone)
    {
        if (isHungry())
        {
            if(isOn){
                for (int i = 0; i < 5; i++) quack();
                isOn = false;
            }
            return Reaction.WAIT;
        }
        if(zone.equals(Zone.WALL))
            return Reaction.CAN_NOT;
        return Reaction.CAN;
    }
}
