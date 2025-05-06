package com.crimeinvestigation.system.dao;

import com.crimeinvestigation.system.dao.CrimeTypeDao;
import com.crimeinvestigation.system.model.CrimeType;
import java.util.List;

public class JdbcRunner {
    public void runJdbcApp() {
        // Create DAO object
        CrimeTypeDao crimeTypeDao = new CrimeTypeDao();

        // Call method to retrieve crime types
        crimeTypeDao.getAllCrimeTypes();
    }
}
