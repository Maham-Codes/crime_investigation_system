package com.crimeinvestigation.system;

import com.crimeinvestigation.system.dao.*;
import com.crimeinvestigation.system.service.CrimeTypeService;
import com.crimeinvestigation.system.service.CaseTrackingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import java.util.List;
import java.util.Map;

@SpringBootApplication
@EntityScan(basePackages = "com.crimeinvestigation.system.model")
public class CrimeInvestigationSystemApplication implements CommandLineRunner {

    @Autowired
    private CrimeTypeService crimeTypeService;

    @Autowired
    private CrimeCaseDao crimeCaseDao;


   /* public static void main(String[] args) {
        SpringApplication.run(CrimeInvestigationApplication.class, args);
    }

*/
    @Override
    public void run(String... args) {

        // Call the CrimeCaseDao method to get closed cases and print them
       /* List<Map<String, Object>> closedCases = crimeCaseDao.getClosedCases();
        for (Map<String, Object> row : closedCases) {
            System.out.println(row);
        }
*/
    }
}
