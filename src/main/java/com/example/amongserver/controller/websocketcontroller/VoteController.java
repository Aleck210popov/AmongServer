package com.example.amongserver.controller.websocketcontroller;

import com.example.amongserver.dto.UserGameDto;
import com.example.amongserver.service.UserGameDtoService;
import lombok.AllArgsConstructor;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.example.amongserver.constant.Const.LINK_CHAT;
import static com.example.amongserver.constant.Const.VOTE_TOPIC;

@RestController
@RequestMapping(LINK_CHAT)
@AllArgsConstructor
public class VoteController {
    private final SimpMessagingTemplate simpleMessageTemplate;
    private final UserGameDtoService userGameDtoService;

    @MessageMapping("/vote")
    public void geoPosSocket(UserGameDto userGameDto) {
        UserGameDto returnUser = userGameDtoService.vote(userGameDto);
        if (returnUser != null) {
            sendMessageToGeoPosition(returnUser);
        } else {
            if (userGameDtoService.isVoteCanceled()) {
                sendMessageToGeoPosition(null);
            }
        }
    }


    private void sendMessageToGeoPosition(UserGameDto userGameDto) {
        // если сообщение отправляется в общий чат
        simpleMessageTemplate.convertAndSend(VOTE_TOPIC, userGameDto);
    }
}
