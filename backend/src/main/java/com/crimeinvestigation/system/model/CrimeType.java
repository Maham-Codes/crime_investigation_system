package com.crimeinvestigation.system.model;

import jakarta.persistence.*;
import lombok.*;


@Entity
@Table(name = "crime_type")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CrimeType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "crime_type_id")
    protected Long typeID;

    @Column(name = "crime_name")
    protected String crimeName;


}
