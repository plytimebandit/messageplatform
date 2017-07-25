package org.plytimebandit.messaging.example02;

import java.util.Collection;

import org.plytimebandit.messaging.util.Payload;

public interface ExampleGateway {

    Collection<?> sendAndReceive(Payload payload);

}
