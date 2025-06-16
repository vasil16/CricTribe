package com.strut.crictribe;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TeamServiceImpl implements TeamService {

    @Autowired
    private TeamRepository teamRepository;
    private PlayerRepository playerRepository;

    @Override
    public Team createTeam(TeamDTO dto) {
        Team team = new Team();
        team.setName(dto.getName());
        team.setPlayers(dto.getPlayers());
        return teamRepository.save(team);
    }

    @Override
    public Team getTeamById(Long id) {
        return teamRepository.findById(id).orElseThrow();
    }

    @Override
    public List<Team> getAllTeams() {
        return teamRepository.findAll();
    }

    @Override
    public List<Player> getPlayers(Long id) {
         Team team = teamRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("Team not found with ID: " + id));
    
    return List.copyOf(team.getPlayers());
    }

    @Override
    public Team addPlayer(Long teamId, Long playerId) {

        Team team = teamRepository.findById(teamId)
        .orElseThrow(() -> new RuntimeException("Team not found"));

    Player player = playerRepository.findById(playerId)
        .orElseThrow(() -> new RuntimeException("Player not found"));

    team.getPlayers().add(player);  // Add player to team
    return teamRepository.save(team); // Save updated team

    }

    @Override
    public Team removePlayer(Long teamId, Long playerId) {

        Team team = teamRepository.findById(teamId)
        .orElseThrow(() -> new RuntimeException("Team not found"));

    Player player = playerRepository.findById(playerId)
        .orElseThrow(() -> new RuntimeException("Player not found"));

    team.getPlayers().remove(player); // Remove player from team
    return teamRepository.save(team);

    }
}
