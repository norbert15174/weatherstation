package com.weatherstation.weatherstation.services;

import com.weatherstation.weatherstation.configurations.FileReaderConfig;
import com.weatherstation.weatherstation.entities.Station;
import com.weatherstation.weatherstation.repositories.StationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StationService {


    private StationRepository stationRepository;
    private FileReaderConfig fileReaderConfig;
    @Autowired
    public StationService(StationRepository stationRepository, FileReaderConfig fileReaderConfig) {
        this.stationRepository = stationRepository;
        this.fileReaderConfig = fileReaderConfig;
    }
    //@EventListener(ApplicationReadyEvent.class)
    public void initDataToDB(){

        Station[] stations = fileReaderConfig.readFile();
        if(stations != null){
            for(Station station : stations) stationRepository.save(station);
        }
    }

    public ResponseEntity<List<Station>> findAllWeatherStations(){
        Optional<List<Station>> stations = stationRepository.findAllStations();
        return stations.map(s -> new ResponseEntity(s, HttpStatus.OK)).orElse(new ResponseEntity(HttpStatus.NOT_FOUND));
    }


}
