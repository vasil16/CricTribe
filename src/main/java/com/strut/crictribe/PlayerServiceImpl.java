package com.strut.crictribe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlayerServiceImpl implements PlayerService {

    @Autowired
    private PlayerRepository playerRepository;

    @Override
    public Player createPlayer(PlayerDTO dto) {
        Player player = new Player();
        player.setName(dto.getName());
        player.setEmail(dto.getEmail());
        player.setPhone(dto.getPhone());
        return playerRepository.save(player);
    }

    @Override
    public Player getPlayerById(Long id) {
        return playerRepository.findById(id).orElseThrow();
    }

    @Override
    public List<Player> getAllPlayers() {
        return playerRepository.findAll();
    }

    @Override
    public List<Team> getAllTeams(Long id) {
        // TODO Auto-generated method stub
        Player player = playerRepository.findById(id).orElseThrow();
        return player.getTeams();
    }
}
