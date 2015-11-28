package com.epam.rs.duck;

import com.epam.rs.logistics.Direction;
import com.epam.rs.logistics.Reaction;
import com.epam.rs.logistics.Zone;
import org.apache.log4j.Logger;

/**
 * Created by Raman_Susla1 on 11/25/2015.
 */
public abstract class Duck {
    public Duck(Zone zone) {
        if (zone == null || zone.equals(Zone.WALL)) {
            throw new RuntimeException("Bad place to start quest");
        }
        this.zone = zone;
    }

    protected final Logger logger = Logger.getLogger(getClass());
    protected static final int STEPS_TO_HUNGRY = 10;
    protected static final double RED_LINE_TO_MOVE = 1;

    private int timeFromLastCharge = 0;
    private double stepValue = 0;
    private Direction direction;


    public Zone getZone() {
        return zone;
    }

    protected Zone zone;

    protected final void swim() {
        logger.info("Swim!");
    }

    protected void walk() {
        logger.info("Walk!");
    }

    protected final void quack() {
        logger.info("Quack!");
    }

    protected void sayHungry() {
        logger.info("I'm hungry! Feed me!");
    }

    public void charge() {
        timeFromLastCharge = 0;
    }

    protected boolean isHungry() {
        return timeFromLastCharge == STEPS_TO_HUNGRY;
    }


    public Reaction tryAction(Direction direction, Zone zone) {

        Reaction reaction = getAvailability(zone);
        if (!Reaction.CAN.equals(reaction)) {
            return reaction;
        }
        final boolean canMove = move(direction);
        if (canMove) {
            this.zone = zone;
        }
        howToOvercome();
        if (timeFromLastCharge < STEPS_TO_HUNGRY) {
            timeFromLastCharge++;
        }
        if (isHungry()) {
            sayHungry();
        }
        return canMove ? Reaction.CAN : Reaction.WAIT;

    }


    protected boolean move(Direction direction) {
        stepValue = this.direction == null || direction.equals(this.direction) ? getStepSize() : stepValue + getStepSize();
        this.direction = direction;
        return RED_LINE_TO_MOVE <= stepValue;
    }

    protected abstract double getStepSize();

    protected abstract void howToOvercome();

    protected abstract Reaction getAvailability(Zone zone);
}
