package com.example.mobilelele.repositories;

import com.example.mobilelele.models.entites.UserRole;
import com.example.mobilelele.models.enums.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface UserRoleRepository extends JpaRepository<UserRole,String> {

    Optional<UserRole> findByRole(Role role);


}
