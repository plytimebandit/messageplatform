package org.plytimebandit.messaging.example02;

import java.util.Collection;

import org.plytimebandit.messaging.util.Payload;

public class ExampleGatewayImpl implements ExampleGateway {

    @Override
    public Collection<?> sendAndReceive(Payload payload) {
        return payload.getPayloadData();
    }

}
