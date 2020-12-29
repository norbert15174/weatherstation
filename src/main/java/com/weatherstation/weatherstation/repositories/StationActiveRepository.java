package com.weatherstation.weatherstation.repositories;

import com.weatherstation.weatherstation.entities.StationActive;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StationActiveRepository extends JpaRepository<StationActive,Long> {


    @Query("select sa from StationActive sa left join fetch sa.positions p left join p.airQuality a left join a.values")
    Optional<List<StationActive>> findAllStations();


}
