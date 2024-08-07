package com.example.amongserver.listener;

import com.example.amongserver.dto.GameStateDto;
import lombok.Getter;
import org.springframework.context.ApplicationEvent;
/*
Класс, служающий для создания слушателя GameStateListener
*/
@Getter
public class GameStateChangedEvent extends ApplicationEvent {
    private final GameStateDto gameStateDto;

    public GameStateChangedEvent(Object source, GameStateDto gameStateDto) {
        super(source);
        this.gameStateDto = gameStateDto;
    }

}
