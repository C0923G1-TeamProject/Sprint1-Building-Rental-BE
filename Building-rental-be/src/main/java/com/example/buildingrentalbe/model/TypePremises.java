package com.example.buildingrentalbe.model;

import jakarta.persistence.*;

@Entity
public class TypePremises {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;

    @ManyToOne
    @JoinColumn(name = "premises_id", referencedColumnName = "id")
    private Premises premises;

    public TypePremises() {
    }

    public TypePremises(Integer id, String name, Premises premises) {
        this.id = id;
        this.name = name;
        this.premises = premises;
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

    public Premises getPremises() {
        return premises;
    }

    public void setPremises(Premises premises) {
        this.premises = premises;
    }
}
