package org.plytimebandit.messaging.example03;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ExampleRouter {

    private static final Logger LOG = LogManager.getLogger(ExampleRouter.class);

    public String route(String payload) {
        LOG.info("Starting ExampleRouter with payload: " + payload);
        char lastChar = payload.charAt(payload.length() - 1);
        int number = Integer.valueOf(lastChar+"");
        return number % 2 == 0 ? "leftChannel" : "rightChannel";
    }

}
