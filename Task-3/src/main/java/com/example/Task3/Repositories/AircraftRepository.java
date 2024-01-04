package com.example.Task3.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.Task3.Models.Aircraft;

@Repository
public interface AircraftRepository extends JpaRepository<Aircraft, Integer> {
    // Define custom query methods here if needed
}