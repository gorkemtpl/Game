package com.example.Game.business.abstracts;

import com.example.Game.business.request.CreateActorRequest;
import com.example.Game.business.request.DeleteActorRequest;
import com.example.Game.business.request.UpdateActorRequest;
import com.example.Game.business.response.GetAllActorsResponse;
import com.example.Game.business.response.GetByIdActorResponse;

import java.util.List;

public interface ActorService {

    List<GetAllActorsResponse> gatAll();

    GetByIdActorResponse getById (Long id);

    void add (CreateActorRequest createActorRequest);

    void delete (Long id);

    void update (UpdateActorRequest updateActorRequest);

}
