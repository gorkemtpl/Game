package com.example.Game.business.abstracts;

import com.example.Game.business.request.CreateCampaignRequest;
import com.example.Game.business.request.UpdateCampaignRequest;
import com.example.Game.business.response.GetAllCampaignsResponse;
import com.example.Game.business.response.GetByIdCampaignResponse;

import java.util.List;

public interface CampaignService {

    List<GetAllCampaignsResponse> getAll();

    GetByIdCampaignResponse getById (Long id);

    void add (CreateCampaignRequest createCampaignRequest);

    void delete (Long id);

    void update (UpdateCampaignRequest updateCampaignRequest);
}
