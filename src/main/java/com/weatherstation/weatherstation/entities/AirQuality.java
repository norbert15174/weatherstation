package com.weatherstation.weatherstation.entities;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Getter
@ToString
@NoArgsConstructor
@Entity
public class AirQuality {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "air_key")
    private String key;
    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private Set<Value> values = new HashSet<>();

    public void addNewValue(Set<Value> values){
        values.addAll(values);
    }

    public void setKey(String key) {
        this.key = key;
    }

    public void setValues(Set<Value> values) {
        this.values = values;
    }
}
