package org.plytimebandit.messaging.example03;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.messaging.Message;

public class ExamplePrinter {

    private static final Logger LOG = LogManager.getLogger(ExamplePrinter.class);

    public List<Object> print(Collection<Message> c) {
        LOG.info("Collected Payload: " + c);
        return c.stream()
                .map(Message::getPayload)
                .collect(Collectors.toList());
    }
}
