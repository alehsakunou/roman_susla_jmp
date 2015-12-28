package com.epam.rs;

import org.apache.log4j.Logger;

/**
 * Created by catmo_000 on 12/29/2015.
 */
public class CustomFunctionality implements SomeFunctionality {
    public final Logger logger = Logger.getLogger(CustomFunctionality.class);
    public void doSomething() {
        logger.info("Yellow submarine!!!");
    }
}
