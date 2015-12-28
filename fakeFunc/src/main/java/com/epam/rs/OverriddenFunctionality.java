package com.epam.rs;

import org.apache.log4j.Logger;

/**
 * Created by catmo_000 on 12/29/2015.
 */
public class OverriddenFunctionality implements SomeInterface {
    private final Logger logger = Logger.getLogger(OverriddenFunctionality.class);
    public void doSomethingOverride() {
        logger.info("overridden functionality");
    }
}
