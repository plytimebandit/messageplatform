package org.plytimebandit.messaging;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.integration.core.MessagingTemplate;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;

public class Main {

    private static final Logger LOG = LogManager.getLogger(Main.class);

    public static void main(String... args) {
        ConfigurableApplicationContext context = new ClassPathXmlApplicationContext(
                "/META-INF/spring/integration.xml");

        MessageChannel channel = context.getBean("exampleChannel", MessageChannel.class);
        Message<Payload> message = MessageBuilder.withPayload(
                new Payload(3)
        ).build();

        MessagingTemplate messagingTemplate = new MessagingTemplate();
        Message<?> returnMessage = messagingTemplate.sendAndReceive(channel, message);

        LOG.info("Return message: " + returnMessage.getPayload());
    }

    static class Payload {

        private List<String> payload = new ArrayList<>();

        public Payload(int i) {
            for (int j = 0; j < i; j++) {
                payload.add("PAYLOAD_" + j);
            }
        }

        public List<String> getPayloadData() {
            return payload;
        }
    }
}
