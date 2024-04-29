package com.example.amongserver.controller.websocketcontroller;


import com.example.amongserver.domain.GeoPosition;
import lombok.AllArgsConstructor;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import java.util.ArrayList;

import static com.example.amongserver.constant.Const.*;

@RestController
@RequestMapping(LINK_CHAT)
@AllArgsConstructor
public class GeoPositionController {
    private final SimpMessagingTemplate simpleMessageTemplate;

    @MessageMapping("/sock")
    public void geoPosSocket(GeoPosition geoPosition) {
        sendMessageToGeoPosition(geoPosition); // отправим сообщения другим пользователям
    }

    private void sendMessageToGeoPosition(GeoPosition geoPosition) {
        // если сообщение отправляется в общий чат
        simpleMessageTemplate.convertAndSend(GEOPOS_TOPIC, geoPosition);
    }
}
