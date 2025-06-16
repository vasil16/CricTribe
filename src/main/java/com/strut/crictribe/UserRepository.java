package com.strut.crictribe;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.strut.crictribe.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmailOrUsername(String email, String username);
    boolean existsByEmailOrUsername(String email, String username); 
}