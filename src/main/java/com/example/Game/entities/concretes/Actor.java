package com.example.Game.entities.concretes;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//import javax.persistence.*;

@Entity
@Table(name = "actor")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Actor {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "actor_id")
    private Long id;

    @Column(name = "actor_identity_number", nullable = false)
    private String identityNumber;

    @Column(name = "actor_first_name", nullable = false)
    private String firstName;

    @Column(name = "actor_last_name", nullable = false)
    private String lastName;

    @Column(name = "actor_birth_year", nullable = false)
    private String birthYear;

}
