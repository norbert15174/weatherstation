package com.weatherstation.weatherstation.repositories;

import com.weatherstation.weatherstation.entities.Station;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StationRepository extends JpaRepository<Station,Long> {

    @Query("SELECT s FROM Station s")
    Optional<List<Station>> findAllStations();

}
