package com.example.Game.business.concretes;

import com.example.Game.business.abstracts.ActorService;
import com.example.Game.business.request.CreateActorRequest;
import com.example.Game.business.request.UpdateActorRequest;
import com.example.Game.business.response.GetAllActorsResponse;
import com.example.Game.business.response.GetByIdActorResponse;
import com.example.Game.core.utilities.mappers.ModelMapperService;
import com.example.Game.dataAccess.abstracts.ActorRepository;
import com.example.Game.entities.concretes.Actor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ActorManager implements ActorService {

    private final ActorRepository actorRepository;

    private final ModelMapperService modelMapperService;

    @Autowired
    public ActorManager(ActorRepository actorRepository, ModelMapperService modelMapperService) {
        this.actorRepository = actorRepository;
        this.modelMapperService = modelMapperService;
    }


    @Override
    public List<GetAllActorsResponse> gatAll() {
        List<Actor> actors = actorRepository.findAll();
        List<GetAllActorsResponse> actorsResponse = actors.stream()
                .map(actor -> this.modelMapperService.forResponse().map(actor, GetAllActorsResponse.class)).collect(Collectors.toList());
        return actorsResponse;

    }

    @Override
    public GetByIdActorResponse getById(Long id) {
        Actor actor = this.actorRepository.findById(id).orElseThrow();

        GetByIdActorResponse response = this.modelMapperService.forResponse().map(actor, GetByIdActorResponse.class);
        return response;
    }

    @Override
    public void add(CreateActorRequest createActorRequest) {
        Actor actor = this.modelMapperService.forRequest().map(createActorRequest, Actor.class);
        this.actorRepository.save(actor);
    }

    @Override
    public void delete(Long id) {
        this.actorRepository.deleteById(id);
    }

    @Override
    public void update(UpdateActorRequest updateActorRequest) {
        Actor actor = this.modelMapperService.forRequest().map(updateActorRequest, Actor.class);
        this.actorRepository.save(actor);
    }
}
