package com.crimeinvestigation.system.model;

import jakarta.persistence.*;


@Entity
public class CrimeType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected int typeID;

    protected String name;

    // Constructors
    public CrimeType() {}

    public CrimeType(int typeID, String name) {
        this.typeID = typeID;
        this.name = name;
    }

    public CrimeType(String name) {
        this.name = name;
    }

    // Getters and Setters
    public int getId() {
        return typeID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void setId(int crimeTypeId) {
        this.typeID = crimeTypeId;
    }
}
