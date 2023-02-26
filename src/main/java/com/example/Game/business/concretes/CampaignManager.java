package com.example.Game.business.concretes;

import com.example.Game.business.abstracts.CampaignService;
import com.example.Game.business.request.CreateCampaignRequest;
import com.example.Game.business.request.UpdateCampaignRequest;
import com.example.Game.business.response.GetAllCampaignsResponse;
import com.example.Game.business.response.GetByIdCampaignResponse;
import com.example.Game.core.utilities.mappers.ModelMapperService;
import com.example.Game.dataAccess.abstracts.CampaignRepository;
import com.example.Game.entities.concretes.Campaign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CampaignManager implements CampaignService {

    private final CampaignRepository campaignRepository;

    private final ModelMapperService modelMapperService;

    @Autowired
    public CampaignManager(CampaignRepository campaignRepository, ModelMapperService modelMapperService) {
        this.campaignRepository = campaignRepository;
        this.modelMapperService = modelMapperService;
    }


    @Override
    public List<GetAllCampaignsResponse> getAll() {
        List<Campaign> campaigns = this.campaignRepository.findAll();
        List<GetAllCampaignsResponse> campaignsResponse = campaigns.stream()
                .map(campaign -> this.modelMapperService.forResponse().map(campaign, GetAllCampaignsResponse.class)).collect(Collectors.toList());
        return campaignsResponse;
    }

    @Override
    public GetByIdCampaignResponse getById(Long id) {
        Campaign campaign = this.campaignRepository.findById(id).orElseThrow();

        GetByIdCampaignResponse response = this.modelMapperService.forRequest().map(campaign, GetByIdCampaignResponse.class);
        return response;
    }

    @Override
    public void add(CreateCampaignRequest createCampaignRequest) {
        Campaign campaign = this.modelMapperService.forRequest().map(createCampaignRequest, Campaign.class);
        this.campaignRepository.save(campaign);
    }

    @Override
    public void delete(Long id) {
        this.campaignRepository.deleteById(id);
    }

    @Override
    public void update(UpdateCampaignRequest updateCampaignRequest) {
        Campaign campaign = this.modelMapperService.forRequest().map(updateCampaignRequest, Campaign.class);
        this.campaignRepository.save(campaign);
    }
}
