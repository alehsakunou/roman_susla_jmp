package com.epam.rs.duck;

import com.epam.rs.logistics.Direction;
import com.epam.rs.logistics.Reaction;
import com.epam.rs.logistics.Zone;
import org.apache.log4j.Logger;

/**
 * Created by Raman_Susla1 on 11/25/2015.
 */
public abstract class Duck
{
    public Duck(Zone zone)
    {
        if(zone==null || zone.equals(Zone.WALL))
        {
            throw new RuntimeException("Bad place to start quest");
        }
        this.zone = zone;
    }
    protected final Logger logger = Logger.getLogger(getClass());
    protected static final int STEPS_TO_HUNGRY = 10;
    protected static final double RED_LINE_TO_MOVE = 1;

    private int stepsToHungry = STEPS_TO_HUNGRY;
    protected double stepValue = 0;
    protected Direction direction;
    protected Zone zone;

    protected final void swim() { logger.info("I swim!"); }
    protected void walk() { logger.info("I walk!"); }
    protected final void quack() { logger.info("I quack!"); }
    protected void sayHungry() { logger.info("I'm hungry! Feed me!"); }
    public void charge() { stepsToHungry = STEPS_TO_HUNGRY; }
    protected boolean isHungry() { return stepsToHungry == 0; }



    public Reaction tryToMove(Direction direction, Zone zone)
    {
        Reaction reaction = getAvailability(zone);
        if (!Reaction.CAN.equals(reaction))
        {
            return reaction;
        }
        final boolean canMove = move(direction);
        this.zone = zone;
        howToOvercome(zone);
        if(stepsToHungry == 0)
        {
            sayHungry();
        }
        return canMove ? Reaction.CAN : Reaction.WAIT;
    }


    protected boolean move(Direction direction)
    {
        stepValue = this.direction == null || direction.equals(this.direction) ? getStepSize() : stepValue + getStepSize();
        this.direction = direction;
        if(stepsToHungry>0) stepsToHungry--;
        return RED_LINE_TO_MOVE <= stepValue;
    }

    protected abstract double getStepSize();
    protected abstract void howToOvercome(Zone zone);
    protected abstract Reaction getAvailability(Zone zone);
}
