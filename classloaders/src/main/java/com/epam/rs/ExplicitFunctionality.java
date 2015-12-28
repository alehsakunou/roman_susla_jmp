package com.epam.rs;

import org.apache.log4j.Logger;

/**
 * Created by catmo_000 on 12/29/2015.
 */
public class ExplicitFunctionality implements SomeInterface {
    private final Logger logger = Logger.getLogger(ExplicitFunctionality.class);

    public void doSomethingOverride() {
        logger.info("explicit functionality");
    }

}
