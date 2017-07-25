package org.plytimebandit.messaging.example03;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ExampleRoutedPrinter {

    private static final Logger LOG = LogManager.getLogger(ExampleRoutedPrinter.class);

    public String printLeft(String payload) {
        LOG.info("Routed payload to left: " + payload);
        return payload;
    }

    public String printRight(String payload) {
        LOG.info("Routed payload to right: " + payload);
        return payload;
    }
}
