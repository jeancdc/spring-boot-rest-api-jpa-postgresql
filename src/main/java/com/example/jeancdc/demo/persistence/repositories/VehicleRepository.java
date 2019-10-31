package com.example.jeancdc.demo.persistence.repositories;

import com.example.jeancdc.demo.persistence.entities.VehicleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VehicleRepository extends JpaRepository<VehicleEntity, Long> {
}
