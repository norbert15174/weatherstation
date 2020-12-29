package com.weatherstation.weatherstation.repositories;

import com.weatherstation.weatherstation.entities.Commune;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommuneRepository extends JpaRepository<Commune,Long> {
}
