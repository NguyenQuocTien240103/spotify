package com.project.stayfinder.repository;

import com.project.stayfinder.entity.Guest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface GuestRepository extends JpaRepository<Guest, String> {
    boolean existsByEmail(String email);
}