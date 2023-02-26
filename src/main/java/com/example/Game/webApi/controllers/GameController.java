package com.example.Game.webApi.controllers;

import com.example.Game.business.abstracts.GameService;
import com.example.Game.business.request.CreateGameRequest;
import com.example.Game.business.request.UpdateGameRequest;
import com.example.Game.business.response.GetAllGamesResponse;
import com.example.Game.business.response.GetByIdGameResponse;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/game")
@AllArgsConstructor
public class GameController {

    private GameService gameService;

    @GetMapping
    public List<GetAllGamesResponse> getAll() {
        return this.gameService.getAll();
    }

    @GetMapping("/{id}")
    public GetByIdGameResponse getById (@PathVariable Long id) {
        return this.gameService.getById(id);
    }

    @PostMapping
    public void add (@RequestBody CreateGameRequest createGameRequest) {
        this.gameService.add(createGameRequest);
    }

    @DeleteMapping("/{id}")
    public void delete (@PathVariable Long id) {
        this.gameService.delete(id);
    }

    @PutMapping
    public void update (@RequestBody UpdateGameRequest updateGameRequest) {
        this.gameService.update(updateGameRequest);
    }
}
