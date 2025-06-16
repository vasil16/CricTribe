package com.strut.crictribe;

import java.util.HashSet;
import java.util.Set;

import lombok.Data;

@Data

public class TeamDTO {

    private String name;
    private Set<Player> players = new HashSet<>();
    
}
