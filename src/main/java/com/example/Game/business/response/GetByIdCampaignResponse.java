package com.example.Game.business.response;

import lombok.Data;

@Data
public class GetByIdCampaignResponse {

    private Long id;
    private String name;
    private double discount;
}
