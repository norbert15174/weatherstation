package com.weatherstation.weatherstation.configurations;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.weatherstation.weatherstation.entities.Station;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.EventListener;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

@Configuration
public class FileReaderConfig {

    public FileReaderConfig() {
    }

    public Station[] readFile(){

        ObjectMapper objectMapper = new ObjectMapper();


        File file = new File("src\\main\\resources\\static\\jso.json");
        try {
            Scanner scanner = new Scanner(file);
            return objectMapper.readValue(scanner.nextLine(),Station[].class);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }


}
