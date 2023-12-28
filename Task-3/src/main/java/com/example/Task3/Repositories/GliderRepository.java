package com.example.Task3.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.Task3.Glider;

@Repository
public interface GliderRepository extends JpaRepository<Glider, Integer> {

}