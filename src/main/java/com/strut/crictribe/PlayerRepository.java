package com.strut.crictribe;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface PlayerRepository extends JpaRepository<Player, Long> {

    
}
