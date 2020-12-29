package com.weatherstation.weatherstation.controllers;

import com.fasterxml.jackson.databind.JsonNode;
import com.weatherstation.weatherstation.entities.AirQuality;
import com.weatherstation.weatherstation.entities.Position;
import com.weatherstation.weatherstation.entities.StationActive;
import com.weatherstation.weatherstation.repositories.AirQualityRepository;
import com.weatherstation.weatherstation.repositories.PositionRepository;
import com.weatherstation.weatherstation.repositories.StationActiveRepository;
import com.weatherstation.weatherstation.repositories.ValueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
public class StationActiveController {

    private RestTemplate restTemplate;

    private StationActiveRepository stationActiveRepository;
    private PositionRepository positionRepository;
    private AirQualityRepository airQualityRepository;
    @Autowired
    public StationActiveController(StationActiveRepository stationActiveRepository, PositionRepository positionRepository, AirQualityRepository airQualityRepository) {
        this.restTemplate = new RestTemplate();
        this.stationActiveRepository = stationActiveRepository;
        this.positionRepository = positionRepository;
        this.airQualityRepository = airQualityRepository;
    }


    //@EventListener(ApplicationReadyEvent.class)
    public void getStationsFromApi(){


        MultiValueMap<String, String> headers = new HttpHeaders();
        headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);

        HttpEntity httpEntity = new HttpEntity(headers);

        StationActive[] jsonNode = restTemplate.exchange("http://api.gios.gov.pl/pjp-api/rest/station/findAll", HttpMethod.GET, httpEntity, StationActive[].class).getBody();
        for(StationActive stationActive : jsonNode) stationActiveRepository.save(stationActive);
    }
  //  @EventListener(ApplicationReadyEvent.class)
    public void getPositionsFromApi(){

        MultiValueMap<String, String> headers = new HttpHeaders();
        headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);

        HttpEntity httpEntity = new HttpEntity(headers);

        List<StationActive> stationActiveList = stationActiveRepository.findAll();

        stationActiveList.forEach(stationActive -> {
            Position[] positions = restTemplate.exchange("http://api.gios.gov.pl/pjp-api/rest/station/sensors/" + stationActive.getId(), HttpMethod.GET, httpEntity, Position[].class).getBody();
            List<Position> positionList = new ArrayList<>();
            for(Position position : positions){
                AirQuality airQualities = restTemplate.exchange("http://api.gios.gov.pl/pjp-api/rest/data/getData/" + position.getId(), HttpMethod.GET, httpEntity, AirQuality.class).getBody();
                position.setAirQuality(airQualities);
                positionList.add(position);
                positionRepository.save(position);
            }
            stationActive.setPositions(positionList);
            stationActiveRepository.save(stationActive);
        });


    }
    @EventListener(ApplicationReadyEvent.class)
    void init(){
        stationActiveRepository.findAllStations().get().get(0).getPositions().get(0).getAirQuality().getValues().forEach(g -> System.out.println(g));
    }


//    @EventListener(ApplicationReadyEvent.class)
//    public void getAirQualityFromApi(){
//
//        MultiValueMap<String, String> headers = new HttpHeaders();
//        headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
//
//        HttpEntity httpEntity = new HttpEntity(headers);
//
//        List<Position> positionList = positionRepository.findAll();
//        positionList.forEach(position -> {
//            AirQuality airQualities = restTemplate.exchange("http://api.gios.gov.pl/pjp-api/rest/data/getData/" + position.getId(), HttpMethod.GET, httpEntity, AirQuality.class).getBody();
//            airQualityRepository.save(airQualities);
//        });}



}
