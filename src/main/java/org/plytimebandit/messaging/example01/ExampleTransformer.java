package org.plytimebandit.messaging.example01;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ExampleTransformer {

    private static final Logger LOG = LogManager.getLogger(ExampleTransformer.class);

    public String transform(String message) {
        LOG.info("Transformer called: " + message);
        return "T_" + message;
    }
}
