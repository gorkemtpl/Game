package com.example.Game.business.response;

import lombok.Data;

@Data
public class GetByIdGameResponse {

    private Long id;
    private String name;
    private double price;
}
