package com.crimeinvestigation.system.model;

import com.crimeinvestigation.system.enums.Gender;
import com.crimeinvestigation.system.enums.UserType;
import jakarta.persistence.Entity;
import com.crimeinvestigation.system.enums.Role;
import jakarta.persistence.*;
import lombok.*;


@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@DiscriminatorValue("User")
public class User extends Person{
    //@Column(name = "address")
    protected String address;

    @Column(unique = true)
    private String email;

    private String password;

    @Enumerated(EnumType.STRING)
    @Column(name = "user_type")
    private UserType userType;

    @Override
    public void displayDetails(){
        System.out.println("Address: " + address);
        System.out.println("Email: " + email);
    }
}
