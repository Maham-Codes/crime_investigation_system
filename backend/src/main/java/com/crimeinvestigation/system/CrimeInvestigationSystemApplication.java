//package com.crimeinvestigation.system;
//
//import com.crimeinvestigation.system.dao.CrimeTypeDao;
//import com.crimeinvestigation.system.model.CrimeType;
//import org.springframework.boot.SpringApplication;
//import org.springframework.boot.autoconfigure.SpringBootApplication;
//
//import java.sql.*;
//import java.util.*;
//
//@SpringBootApplication
//public class CrimeInvestigationSystemApplication {
//
//    public CrimeInvestigationSystemApplication() throws SQLException {
//        CrimeTypeDao crimeTypeDao = null;
//        List<CrimeType> types = crimeTypeDao.getAllCrimeTypes();
//        types.forEach(type -> System.out.println("TypeID: " + type.getTypeID() + ", Name: " + type.getCrimeName()));
//    }
//
//
//}
package com.crimeinvestigation.system;

import com.crimeinvestigation.system.dao.CrimeTypeDao;
import com.crimeinvestigation.system.model.CrimeType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.util.List;

@SpringBootApplication
public class CrimeInvestigationSystemApplication implements CommandLineRunner {

    @Autowired
    private CrimeTypeDao crimeTypeDao;

    public static void main(String[] args) {
        SpringApplication.run(CrimeInvestigationSystemApplication.class, args);
    }

    @Override
    public void run(String... args) {
        List<CrimeType> types = crimeTypeDao.getAllCrimeTypes();
        types.forEach(type -> System.out.println("TypeID: " + type.getTypeID() + ", Name: " + type.getCrimeName()));
    }
}
