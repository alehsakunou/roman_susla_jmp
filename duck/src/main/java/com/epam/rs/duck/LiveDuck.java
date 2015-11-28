package com.epam.rs.duck;

import com.epam.rs.logistics.Reaction;
import com.epam.rs.logistics.Zone;

/**
 * Created by Raman_Susla1 on 11/25/2015.
 */
public class LiveDuck extends Duck {
    private static final double STEP_SIZE = 1;

    /**
     * create live duck
     * @param zone init start terrain
     */
    public LiveDuck(Zone zone) {
        super(zone);
    }

    /**
     * fly
     */
    public void fly() {
        logger.info("Fly!");
    }

    /**
     *
     * @return speed: 1 for live
     */
    @Override
    protected double getStepSize() {
        return STEP_SIZE;
    }

    /**
     * say, how zone will be passed if hungry then walk|swim otherwise fly
     */
    @Override
    protected void howToOvercome() {
        Zone zone = getZone();
        if (isHungry()) {
            if (zone.equals(Zone.FLATLAND) || zone.equals(Zone.START) || zone.equals(Zone.FINISH)) {
                walk();
                return;
            }
            if (zone.equals(Zone.WATER)) {
                swim();
                return;
            }
        }
        fly();
    }

    /**
     * check is it possible to go to the new location
     * @param zone new location type
     * @return GO if can overcome
     */
    @Override
    protected Reaction getAvailability(Zone zone) {
        return zone.equals(Zone.WALL) ? Reaction.IMPOSSIBLE : Reaction.GO;
    }

    /**
     * eat if on flatland| drink if on water
     */
    @Override
    public void charge() {
        logger.info(getZone().equals(Zone.WATER) ? "Drink!" : "Eat!");
    }
}
