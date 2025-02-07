package com.microserviciologistic.deleteuser.websocket;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.microserviciologistic.deleteuser.model.WebSocketEvent;
import org.springframework.stereotype.Service;

@Service
public class WebSocketMessageHandler {
    private final ObjectMapper objectMapper = new ObjectMapper();

    public void processMessage(String message) {
        try {
            WebSocketEvent event = objectMapper.readValue(message, WebSocketEvent.class);
            System.out.println("Event recived: " + event);
        } catch (Exception e) {
            System.err.println(" Error to process the message: " + e.getMessage());
        }
    }
}
