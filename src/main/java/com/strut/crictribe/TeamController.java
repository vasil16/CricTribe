
package com.strut.crictribe;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/teams")
public class TeamController {

    @Autowired
    private TeamService teamService;

    @PostMapping
    public ResponseEntity<Team> createTeam(@RequestBody TeamDTO dto) {
        return ResponseEntity.ok(teamService.createTeam(dto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Team> getPlayer(@PathVariable Long id) {
        return ResponseEntity.ok(teamService.getTeamById(id));
    }


    public ResponseEntity<List<Team>> getAllTeams() {
        return ResponseEntity.ok(teamService.getAllTeams());
    }

    @GetMapping("/{id}/players")
    public ResponseEntity<List<Player>> getTeamPlayers(@PathVariable Long id) {
        return ResponseEntity.ok(teamService.getPlayers(id));
    }

    @PutMapping("/{teamId}/add-player/{playerId}")
    public ResponseEntity<Team> addPlayerToTeam(@PathVariable Long teamId, @PathVariable Long playerId) {
        return ResponseEntity.ok(teamService.addPlayer(teamId, playerId));
    }

    @PutMapping("/{teamId}/remove-player/{playerId}")
    public ResponseEntity<Team> removePlayerFromTeam(@PathVariable Long teamId, @PathVariable Long playerId) {
        return ResponseEntity.ok(teamService.removePlayer(teamId, playerId));
    }
}
