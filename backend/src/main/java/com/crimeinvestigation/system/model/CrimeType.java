package com.crimeinvestigation.system.model;

import jakarta.persistence.*;
import lombok.*;


@Entity
@Table(name = "crimetype")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CrimeType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "type_id")
    protected int typeID;

    @Column(name = "crime_name")
    protected String crimeName;


}
