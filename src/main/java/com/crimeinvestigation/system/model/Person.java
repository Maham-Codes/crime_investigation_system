package com.crimeinvestigation.system.model;
import jakarta.persistence.*;

public class Person {
    @Id
    protected int personId;
    protected String name;
    protected String fatherName;
}
