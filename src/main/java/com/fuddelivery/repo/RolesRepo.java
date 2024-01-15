package com.fuddelivery.repo;

import com.fuddelivery.entity.Roles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface RolesRepo extends JpaRepository<Roles, Long> {


    @Query(value = "SELECT * FROM `roles` WHERE roles = ?1 " , nativeQuery = true)
    Optional<Roles> findByName(String roles);
}
