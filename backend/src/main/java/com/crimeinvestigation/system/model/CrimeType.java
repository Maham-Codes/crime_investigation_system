package com.crimeinvestigation.system.model;

import jakarta.persistence.*;
import lombok.*;


@Entity
@Table(name = "crimetype")
@Getter
@Setter
public class CrimeType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected int typeID;

    protected String crimeName;


}
