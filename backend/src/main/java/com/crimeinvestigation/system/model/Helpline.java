package com.crimeinvestigation.system.model;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "helpline")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
    public class Helpline {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected int helplineID;
        private String region_area,helplinenumber,helplinetype;

        public void DisplayInfo() {
            System.out.println(helplinenumber);
            System.out.println(helplinetype);
            System.out.println(region_area);
        }

}
