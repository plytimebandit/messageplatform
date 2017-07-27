package org.plytimebandit.messaging;

import java.util.Collection;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.plytimebandit.messaging.example02.ExampleGateway;
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
    private ExampleGateway example02Gateway;
    private ExampleGateway example03Gateway;
    private ExampleGateway example04Gateway;

    public static void main(String... args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("/META-INF/spring/integration.xml");

        Main main = context.getBean(Main.class);

//        main.runExample01();
//        main.runExample02();
//        main.runExample03();
        main.runExample04();
    }

    private void runExample04() {
        LOG.info("Running example 04");
        Collection<?> result = example04Gateway.sendAndReceive(new Payload(5));
        LOG.info("Return message: " + result);

    }

    private void runExample03() {
        LOG.info("Running example 03");
        Collection<?> result = example03Gateway.sendAndReceive(new Payload(3));
        LOG.info("Return message: " + result);
    }

    private void runExample02() {
        LOG.info("Running example 02");
        Collection<?> result = example02Gateway.sendAndReceive(new Payload(3));
        LOG.info("Return message: " + result);
    }

    private void runExample01() {
        LOG.info("Running example 01");

        Message<Payload> message = MessageBuilder.withPayload(new Payload(3)).build();
        MessagingTemplate messagingTemplate = new MessagingTemplate();
        Message<?> returnMessage = messagingTemplate.sendAndReceive(example01Channel, message);

        LOG.info("Return message: " + returnMessage.getPayload());
    }

    public void setExample01Channel(MessageChannel example01Channel) {
        this.example01Channel = example01Channel;
    }

    public void setExample02Gateway(ExampleGateway example02Gateway) {
        this.example02Gateway = example02Gateway;
    }

    public void setExample03Gateway(ExampleGateway example03Gateway) {
        this.example03Gateway = example03Gateway;
    }

    public void setExample04Gateway(ExampleGateway example04Gateway) {
        this.example04Gateway = example04Gateway;
    }
}
