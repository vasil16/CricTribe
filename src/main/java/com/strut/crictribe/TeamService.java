package com.strut.crictribe;

import java.util.List;

public interface TeamService {

    Team createTeam(TeamDTO teamDTO);
    Team getTeamById(Long id);
    List<Team> getAllTeams();
    List<Player>getPlayers(Long id);
    Team addPlayer(Long teamId, Long playerId);
    Team removePlayer(Long teamId, Long playerId);
}
