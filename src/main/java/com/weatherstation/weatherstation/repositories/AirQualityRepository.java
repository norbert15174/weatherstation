package com.weatherstation.weatherstation.repositories;

import com.weatherstation.weatherstation.entities.AirQuality;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AirQualityRepository extends JpaRepository<AirQuality,Long> {
}
