package com.example.mobilelele.repositories;

import com.example.mobilelele.models.entites.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository  extends JpaRepository<User,String> {

    Optional<User> findByUsername(String username);
}
