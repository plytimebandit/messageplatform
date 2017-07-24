package org.plytimebandit.messaging.util;

import java.util.ArrayList;
import java.util.List;

public class Payload {

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
