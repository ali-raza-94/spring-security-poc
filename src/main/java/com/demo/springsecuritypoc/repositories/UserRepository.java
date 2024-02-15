package com.demo.springsecuritypoc.repositories;

import com.demo.springsecuritypoc.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    public Optional<User> findByUsernameAndEnabledIsTrue(String username);
}
