package com.crimeinvestigation.system.model;

import jakarta.persistence.*;


@Entity
public class CrimeType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected int crimeTypeId;

    protected String name;

    // Constructors
    public CrimeType() {}

    public CrimeType(int crimeTypeId,String name) {
        this.crimeTypeId = crimeTypeId;
        this.name = name;
    }

    public CrimeType(String name) {
        this.name = name;
    }

    // Getters and Setters
    public int getId() {
        return crimeTypeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void setId(int crimeTypeId) {
        this.crimeTypeId = crimeTypeId;
    }
}
