package com.example.Game.business.abstracts;

import com.example.Game.business.request.CreateGameRequest;
import com.example.Game.business.request.UpdateGameRequest;
import com.example.Game.business.response.GetAllGamesResponse;
import com.example.Game.business.response.GetByIdGameResponse;

import java.util.List;

public interface GameService {

    List<GetAllGamesResponse> getAll();

    GetByIdGameResponse getById (Long id);

    void add (CreateGameRequest createGameRequest);

    void delete (Long id);

    void update (UpdateGameRequest updateGameRequest);
}
