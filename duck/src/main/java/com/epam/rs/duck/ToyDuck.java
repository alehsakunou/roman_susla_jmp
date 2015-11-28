package com.epam.rs.duck;

import com.epam.rs.logistics.Reaction;
import com.epam.rs.logistics.Zone;

/**
 * Created by Raman_Susla1 on 11/25/2015.
 */
public class ToyDuck extends Duck {
    private static final double STEP_SIZE = 0.5;
    private boolean isOn = true;

    public ToyDuck(Zone zone) {
        super(zone);
    }

    /**
     * wing swing
     */
    public void flitter() {
        logger.info("Flit");
    }

    /**
     * walk and flit
     */
    @Override
    public void walk() {
        super.walk();
        flitter();
    }

    /**
     * Change battery!
     */
    @Override
    public void charge() {
        isOn = true;
        logger.info("Change battery!");
    }

    @Override
    protected double getStepSize() {
        return STEP_SIZE;
    }

    @Override
    protected void howToOvercome() {
        Zone zone = getZone();
        if (isOn) {
            if (zone.equals(Zone.FLATLAND) || zone.equals(Zone.START) || zone.equals(Zone.FINISH)) {
                walk();
                return;
            }
            if (zone.equals(Zone.WATER)) {
                swim();
            }
        }
    }

    @Override
    protected Reaction getAvailability(Zone zone) {
        if (isOn && zone.equals(Zone.WALL))
            return Reaction.IMPOSSIBLE;
        if (isHungry()) {
            if (isOn) {
                for (int i = 0; i < 5; i++) quack();
                isOn = false;
            }
            return Reaction.WAIT;
        }
        return Reaction.GO;
    }
}
