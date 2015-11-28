package com.epam.rs.duck;

import com.epam.rs.logistics.Direction;
import com.epam.rs.logistics.Reaction;
import com.epam.rs.logistics.Zone;
import org.apache.log4j.Logger;

/**
 * Created by Raman_Susla1 on 11/25/2015.
 */
public abstract class Duck implements ISimpleDuck {
    protected static final int STEPS_TO_HUNGRY = 10;
    protected static final double RED_LINE_TO_MOVE = 1;
    protected final Logger logger = Logger.getLogger(getClass());

    /**
     * create duck
     * @param zone start location type
     */
    public Duck(Zone zone) {
        if (zone == null || zone.equals(Zone.WALL)) {
            throw new RuntimeException("Bad place to start quest");
        }
        this.zone = zone;
    }

    private int timeFromLastCharge = 0;
    private double stepValue = 0;
    protected Zone zone = Zone.START;
    private Direction direction;

    /**
     * @return current location type
     */
    public final Zone getZone() {
        return zone;
    }

    /**
     * swim
     */
    protected final void swim() {
        logger.info("Swim!");
    }
    /**
     * walk
     */
    protected void walk() {
        logger.info("Walk!");
    }
    /**
     * quack
     */
    public final void quack() {
        logger.info("Quack!");
    }
    /**
     * say hungry
     */
    protected final void sayHungry() {
        logger.info("I'm hungry! Feed me!");
    }

    /**
     * try to get ENERGY
     */
    public final void tryCharge() {
        charge();
        timeFromLastCharge = 0;
    }

    protected final boolean isHungry() {
        return timeFromLastCharge == STEPS_TO_HUNGRY;
    }

    /**
     * analyse direction and current state, if can - GO
     * @param direction new direction
     * @param zone new location
     * @return if can - GO
     */
    public Reaction tryAction(Direction direction, Zone zone) {
        Reaction reaction = getAvailability(zone);
        if (!Reaction.GO.equals(reaction)) return reaction;

        stepValue = this.direction == null || !direction.equals(this.direction) ? getStepSize() : stepValue + getStepSize();
        final boolean canMove = RED_LINE_TO_MOVE <= stepValue;
        if (canMove) {
            this.zone = zone;
            stepValue = 0;
            this.direction = null;
        }
        else {
            this.direction =  direction;
        }
        howToOvercome();
        if (timeFromLastCharge < STEPS_TO_HUNGRY) timeFromLastCharge++;
        if (isHungry()) sayHungry();
        return canMove ? Reaction.GO : Reaction.WAIT;

    }

    /**
     * @return points to get step to another square
     */
    protected abstract double getStepSize();

    /**
     * how to overcome new location
     */
    protected abstract void howToOvercome();

    /**
     * check is it posible to overcome new location
     * @param zone new location
     * @return result
     */
    protected abstract Reaction getAvailability(Zone zone);

    /**
     * snikersni
     */
    protected abstract void charge();

}
