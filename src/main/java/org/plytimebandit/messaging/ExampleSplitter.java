package org.plytimebandit.messaging;


import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ExampleSplitter {

    private static final Logger LOG = LogManager.getLogger(ExampleSplitter.class);

    public List<String> split(Main.Payload payload) {
        LOG.info("Splitter called: " + payload.getPayloadData());
        return payload.getPayloadData();
    }
}
