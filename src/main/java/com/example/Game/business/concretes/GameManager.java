package com.example.Game.business.concretes;

import com.example.Game.business.abstracts.GameService;
import com.example.Game.business.request.CreateGameRequest;
import com.example.Game.business.request.UpdateGameRequest;
import com.example.Game.business.response.GetAllGamesResponse;
import com.example.Game.business.response.GetByIdGameResponse;
import com.example.Game.core.utilities.mappers.ModelMapperService;
import com.example.Game.dataAccess.abstracts.GameRepository;
import com.example.Game.entities.concretes.Game;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class GameManager implements GameService {

    private final GameRepository gameRepository;

    private final ModelMapperService modelMapperService;

    @Autowired
    public GameManager(GameRepository gameRepository, ModelMapperService modelMapperService) {
        this.gameRepository = gameRepository;
        this.modelMapperService = modelMapperService;
    }

    @Override
    public List<GetAllGamesResponse> getAll() {
        List<Game> games = this.gameRepository.findAll();
        List<GetAllGamesResponse> gamesResponse = games.stream()
                .map(game -> this.modelMapperService.forRequest().map(game, GetAllGamesResponse.class)).collect(Collectors.toList());
        return gamesResponse;
    }

    @Override
    public GetByIdGameResponse getById(Long id) {
        Game game = this.gameRepository.findById(id).orElseThrow();

        GetByIdGameResponse response = this.modelMapperService.forRequest().map(game, GetByIdGameResponse.class);
        return response;
    }

    @Override
    public void add(CreateGameRequest createGameRequest) {
        Game game = this.modelMapperService.forRequest().map(createGameRequest, Game.class);
        this.gameRepository.save(game);
    }

    @Override
    public void delete(Long id) {
        this.gameRepository.deleteById(id);

    }

    @Override
    public void update(UpdateGameRequest updateGameRequest) {
        Game game = this.modelMapperService.forRequest().map(updateGameRequest, Game.class);
        this.gameRepository.save(game);
    }
}
