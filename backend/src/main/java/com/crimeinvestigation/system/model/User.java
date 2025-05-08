package com.crimeinvestigation.system.model;

import jakarta.persistence.Entity;
import com.crimeinvestigation.system.enums.UserType;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "user")
@PrimaryKeyJoinColumn(name = "personID")
public class User extends Person{
    protected String Address;

    @Column(unique = true)
    private String email;

    private String password;


    @Enumerated(EnumType.STRING)
    private UserType userType;

    @Override
    public void displayDetails(){
        super.displayDetails();
        System.out.println("Email: " + email);
        System.out.println("UserType: " + userType);
        System.out.println("Address: " + Address);
    }
}
