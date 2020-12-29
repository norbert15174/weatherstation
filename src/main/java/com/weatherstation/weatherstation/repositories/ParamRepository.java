package com.weatherstation.weatherstation.repositories;

import com.weatherstation.weatherstation.entities.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParamRepository extends JpaRepository<Param,Long> {
}
