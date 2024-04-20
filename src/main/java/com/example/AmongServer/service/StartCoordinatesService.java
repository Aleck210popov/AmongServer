package com.example.AmongServer.service;

import com.example.AmongServer.domain.StartCoordinates;

import java.util.List;

public interface StartCoordinatesService{
    StartCoordinates add(StartCoordinates startCoordinates);
    List<StartCoordinates> getAll();
    StartCoordinates getById(long id);
}