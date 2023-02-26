package com.example.Game.dataAccess.abstracts;

import com.example.Game.entities.concretes.Campaign;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CampaignRepository extends JpaRepository<Campaign, Long> {

    boolean existsById (Long id);
}
