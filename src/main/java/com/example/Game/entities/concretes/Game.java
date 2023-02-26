package com.example.Game.entities.concretes;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//import javax.persistence.*;

@Entity
@Table(name = "game")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Game {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "game_id")
    private Long id;

    @Column(name = "game_name")
    private String name;

    @Column(name = "game_price")
    private double price;

}
