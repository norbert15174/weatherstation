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
public class City {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private long cityId;
        private int id;
        private String name;

        @OneToOne(cascade = CascadeType.ALL)
        private Commune commune;
}
