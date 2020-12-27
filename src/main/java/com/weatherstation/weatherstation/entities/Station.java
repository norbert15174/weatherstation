package com.weatherstation.weatherstation.entities;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Setter
@Getter
@ToString
@NoArgsConstructor
@Entity
public class Station{
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        public long id;
        public int nr;
        public String kodStacji;
        public String nazwaStacji;
        public String staryKodStacji;
        public String dataUruchomienia;
        public String dataZamkniecia;
        public String status;
        public String typStacji;
        public String typObszaru;
        public String rodzajStacji;
        public String wojewodztwo;
        public String miejscowosc;
        public double lat;
        public double lon;
        public String ulica;
        public String kodMiedzynarodowy;
        @JsonProperty("nazwa.stacji")
        public String nazwaStacjiN;
        @JsonProperty("rodzaj.stacji")
        public String rodzajStacjiN;
}
