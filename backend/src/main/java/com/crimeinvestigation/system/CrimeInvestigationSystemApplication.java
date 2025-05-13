package com.crimeinvestigation.system;

import com.crimeinvestigation.system.dao.*;
import com.crimeinvestigation.system.service.CrimeTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;


@SpringBootApplication
@EntityScan(basePackages = "com.crimeinvestigation.system.model")
public class CrimeInvestigationSystemApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(CrimeInvestigationSystemApplication.class, args);


    }

    @Override
    public void run(String... args) throws Exception {

    }
}
