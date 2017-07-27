package org.plytimebandit.messaging.example04;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ExampleFilter {

    private static final Logger LOG = LogManager.getLogger(ExampleFilter.class);

    public boolean accept(String payload) {
        LOG.info("Starting ExampleFilter with payload: " + payload);
        char lastChar = payload.charAt(payload.length() - 1);
        int number = Integer.valueOf(lastChar+"");
        return number % 2 == 0;
    }

}
