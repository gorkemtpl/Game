package com.example.Game.business.response;

import lombok.Data;

@Data
public class GetAllGamesResponse {

    private Long id;
    private String name;
    private double price;
}
