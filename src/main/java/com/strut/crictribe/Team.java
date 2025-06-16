package com.strut.crictribe;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.*;
import lombok.Data;


@Entity
@Data
public class Team {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToOne
    @JoinColumn(name = "created_by_id")
    private Player createdBy;

    @ManyToMany
    @JoinTable(
        name = "team_players",
        joinColumns = @JoinColumn(name = "team_id"),
        inverseJoinColumns = @JoinColumn(name = "player_id")
    )
    private Set<Player> players = new HashSet<>();

    @ManyToMany
    @JoinTable(
        name = "team_admins",
        joinColumns = @JoinColumn(name = "team_id"),
        inverseJoinColumns = @JoinColumn(name = "admin_id")
    )
    private Set<Player> admins = new HashSet<>();
}
