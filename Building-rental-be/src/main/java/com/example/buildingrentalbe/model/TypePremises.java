package com.example.buildingrentalbe.model;

import jakarta.persistence.*;

@Entity
public class TypePremises {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;

    public TypePremises(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public TypePremises() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
