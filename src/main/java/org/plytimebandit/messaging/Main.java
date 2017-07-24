package org.plytimebandit.messaging;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.plytimebandit.messaging.util.Payload;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.integration.core.MessagingTemplate;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;

public class Main {

    private static final Logger LOG = LogManager.getLogger(Main.class);

    private MessageChannel example01Channel;

    public static void main(String... args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("/META-INF/spring/integration.xml");

        Main main = context.getBean(Main.class);
        main.runExample01();
    }

    private void runExample01() {
        Message<Payload> message = MessageBuilder.withPayload(
                new Payload(3)
        ).build();

        MessagingTemplate messagingTemplate = new MessagingTemplate();
        Message<?> returnMessage = messagingTemplate.sendAndReceive(example01Channel, message);

        LOG.info("Return message: " + returnMessage.getPayload());
    }

    public void setExample01Channel(MessageChannel example01Channel) {
        this.example01Channel = example01Channel;
    }
}
