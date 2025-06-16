package com.strut.crictribe;

import java.util.List;

public interface PlayerService {
    Player createPlayer(PlayerDTO playerDTO);
    Player getPlayerById(Long id);
    List<Player> getAllPlayers();
    List<Team> getAllTeams(Long id);
}