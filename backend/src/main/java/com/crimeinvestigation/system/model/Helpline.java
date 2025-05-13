package com.crimeinvestigation.system.model;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serial;
import java.io.Serializable;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "helpline")
    public class Helpline implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "helpline_id")
    protected Long helplineID;
    @Column(name = "region_area")
        private String region_area;

    @Column(name = "helpline_number")
        private String helplinenumber;

    @Column(name = "helpline_type")
        private String helplinetype;

        public void DisplayInfo() {
            System.out.println(helplinenumber);
            System.out.println(helplinetype);
            System.out.println(region_area);
        }

}
