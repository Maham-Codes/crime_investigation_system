package com.crimeinvestigation.system.model;

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
    protected String address;

    @Column(unique = true)
    private String email;

    private String password;

    @Enumerated(EnumType.STRING)
   // private UserType userType;
    private Role role;

    @Override
    public void displayDetails(){
        super.displayDetails();
        System.out.println("Address: " + address);
        System.out.println("Email: " + email);
        System.out.println("UserType: " + role);
    }
}
