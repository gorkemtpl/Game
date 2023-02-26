package com.example.Game.webApi.controllers;

import com.example.Game.business.abstracts.ActorService;
import com.example.Game.business.request.CreateActorRequest;
import com.example.Game.business.request.UpdateActorRequest;
import com.example.Game.business.response.GetAllActorsResponse;
import com.example.Game.business.response.GetByIdActorResponse;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/actor")
@AllArgsConstructor
public class ActorController {

    private ActorService actorService;

    @GetMapping
    public List<GetAllActorsResponse> getAll() {
        return this.actorService.gatAll();
    }

    @GetMapping("/{id}")
    public GetByIdActorResponse getById(@PathVariable Long id) {
        return this.actorService.getById(id);
    }

    @PostMapping()
    public void add (@RequestBody CreateActorRequest createActorRequest) {
        this.actorService.add(createActorRequest);
    }

    @DeleteMapping("/{id}")
    public void delete (@PathVariable Long id) {
        this.actorService.delete(id);
    }

    @PutMapping
    public void update (@RequestBody UpdateActorRequest updateActorRequest) {
        this.actorService.update(updateActorRequest);
    }
}
