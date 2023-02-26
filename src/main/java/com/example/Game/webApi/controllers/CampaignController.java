package com.example.Game.webApi.controllers;

import com.example.Game.business.abstracts.CampaignService;
import com.example.Game.business.request.CreateCampaignRequest;
import com.example.Game.business.request.UpdateCampaignRequest;
import com.example.Game.business.response.GetAllCampaignsResponse;
import com.example.Game.business.response.GetByIdCampaignResponse;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/camp")
@AllArgsConstructor
public class CampaignController {

    private CampaignService campaignService;

    @GetMapping
    public List<GetAllCampaignsResponse> getAll() {
        return this.campaignService.getAll();
    }

    @GetMapping("/{id}")
    public GetByIdCampaignResponse getById (@PathVariable Long id) {
        return this.campaignService.getById(id);
    }

    @PostMapping
    public void add (@RequestBody CreateCampaignRequest createCampaignRequest) {
        this.campaignService.add(createCampaignRequest);
    }

    @DeleteMapping("/{id}")
    public void delete (@PathVariable Long id) {
        this.campaignService.delete(id);
    }

    @PutMapping
    public void update (@RequestBody UpdateCampaignRequest updateCampaignRequest) {
        this.campaignService.update(updateCampaignRequest);
    }
}
