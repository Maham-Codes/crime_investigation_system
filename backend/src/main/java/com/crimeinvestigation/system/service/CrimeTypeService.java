package com.crimeinvestigation.system.service;

import com.crimeinvestigation.system.dao.CrimeTypeDao;
import com.crimeinvestigation.system.model.CrimeType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CrimeTypeService {

    @Autowired
    private CrimeTypeDao crimeTypeDao;

    public void displayAllCrimeTypes() {
        List<CrimeType> types = crimeTypeDao.getAllCrimeTypes();
        System.out.println("=== Crime Types in Database ===");
        types.forEach(type -> System.out.println("Type ID: " + type.getTypeID() + ", Crime Name: " + type.getCrimeName()));
    }
}
