package com.weatherstation.weatherstation.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Setter
@Getter
@ToString
@NoArgsConstructor
@Entity
public class StationActive{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long stationID;

    private int id;


    private String stationName;
    private String gegrLat;
    private String gegrLon;
    @OneToOne(cascade = CascadeType.ALL)
    private City city;
    private String addressStreet;

    @OneToMany
    List<Position> positions = new ArrayList<>();

}
