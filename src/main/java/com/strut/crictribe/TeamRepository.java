package com.strut.crictribe;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeamRepository  extends JpaRepository<Team, Long>{
    
}
