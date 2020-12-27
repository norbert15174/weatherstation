package com.weatherstation.weatherstation.controllers;

import com.weatherstation.weatherstation.entities.Station;
import com.weatherstation.weatherstation.services.StationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/station")
public class StationRestController {


    private StationService stationService;
    @Autowired
    public StationRestController(StationService stationService) {
        this.stationService = stationService;
    }
    @GetMapping
    public ResponseEntity<List<Station>>  findAllStation(){
        return stationService.findAllWeatherStations();
    }


}
