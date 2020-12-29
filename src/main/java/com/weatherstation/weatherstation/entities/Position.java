package com.weatherstation.weatherstation.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Setter
@Getter
@ToString
@NoArgsConstructor
@Entity
public class Position {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long positionId;
    private int id;
    @OneToOne(cascade = CascadeType.ALL)
    private Param param;
    @OneToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private AirQuality airQuality = new AirQuality();
}
