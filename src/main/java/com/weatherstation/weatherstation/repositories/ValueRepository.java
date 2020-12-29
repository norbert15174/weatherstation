package com.weatherstation.weatherstation.repositories;

import com.weatherstation.weatherstation.entities.Value;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ValueRepository extends JpaRepository<Value,Long> {
}
