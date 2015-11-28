package com.epam.rs.duck;

import com.epam.rs.logistics.Zone;

/**
 * Created by catmo_000 on 11/29/2015.
 */
public enum DuckFactory {
    LIVE {
        @Override
        public Duck createDuck(Zone zone) {
            return new LiveDuck(zone);
        }
    }, TOY {
        @Override
        public Duck createDuck(Zone zone) {
            return new ToyDuck(zone);
        }
    };

    public abstract Duck createDuck(Zone zone);
}
