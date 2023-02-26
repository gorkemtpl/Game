package com.example.Game.dataAccess.abstracts;

import com.example.Game.entities.concretes.Actor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ActorRepository extends JpaRepository<Actor, Long> {

    boolean existsById (Long id);
}
