package com.crimeinvestigation.system.model;

import com.crimeinvestigation.system.enums.Crimetypes;
import jakarta.persistence.*;
import lombok.*;


@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "crime_type")
public class CrimeType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "crime_type_id")
    protected Long typeID;

    @Enumerated(EnumType.STRING)
    @Column(name = "crime_name")
    protected Crimetypes type;


}
