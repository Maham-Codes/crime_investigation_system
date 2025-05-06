package com.crimeinvestigation.system.dao;

import com.crimeinvestigation.system.dao.CrimeTypeDao;
import com.crimeinvestigation.system.model.CrimeType;
import java.util.List;

public class JdbcRunner {
    public void runJdbcApp() {

        //Gives all crime types
        CrimeTypeDao crimeTypeDao = new CrimeTypeDao();
        crimeTypeDao.getAllCrimeTypes();

        //gives all the helplines in region islamabad and related to murder
        HelplineDao helplineDao = new HelplineDao();
        helplineDao.getHelplinesByRegionAndType("Islamabad", "Murder");

    }
}