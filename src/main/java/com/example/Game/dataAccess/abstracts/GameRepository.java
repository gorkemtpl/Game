package com.example.Game.dataAccess.abstracts;

import com.example.Game.entities.concretes.Game;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameRepository extends JpaRepository<Game, Long> {

    boolean existsById (Long id);
}
