package org.plytimebandit.messaging.example01;


import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.plytimebandit.messaging.util.Payload;

public class ExampleSplitter {

    private static final Logger LOG = LogManager.getLogger(ExampleSplitter.class);

    public List<String> split(Payload payload) {
        LOG.info("Splitter called: " + payload.getPayloadData());
        return payload.getPayloadData();
    }
}
