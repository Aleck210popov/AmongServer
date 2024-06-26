package com.example.amongserver.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserGeoPositionDto {

    private Long id;

    private double latitude;

    private double longitude;

    private boolean isDead;
}
