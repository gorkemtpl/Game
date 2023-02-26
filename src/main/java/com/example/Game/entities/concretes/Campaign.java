package com.example.Game.entities.concretes;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//import javax.persistence.*;

@Entity
@Table(name = "campaign")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Campaign {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "campaign_id")
    private Long id;

    @Column(name = "campaign_name", nullable = false)
    private String name;

    @Column(name = "campaign_discount", nullable = false)
    private double discount;
}
