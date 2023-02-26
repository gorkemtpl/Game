package com.example.Game.business.response;

import lombok.Data;

@Data
public class GetByIdActorResponse {

    private Long id;
    private String identityNumber;
    private String firstName;
    private String lastName;
    private String birthYear;
}
