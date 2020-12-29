package com.weatherstation.weatherstation.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import javax.persistence.Id;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Setter
@Getter
@ToString
@NoArgsConstructor
@Entity
public class Commune {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private long Id;

        private String communeName;
        private String districtName;
        private String provinceName;

}
