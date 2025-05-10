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
    protected int typeID;

    @Column(name = "crimeName")
    protected String name;


}
