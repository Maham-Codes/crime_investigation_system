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

        //joins query.
        //Gives info about convicted criminals
        CriminalDao dao = new CriminalDao();
        dao.getActiveCriminalCases();

        //non correlated subquery
        //all cases that have more updates than the average number of updates per case
        CaseTrackingDao caseDao = new CaseTrackingDao();
        caseDao.getCasesWithAboveAverageUpdates();

        //correlated subquery
        //List cases where the latest tracking update contains the word 'Closed'.
        CrimeCaseDao closedDao = new CrimeCaseDao();
        closedDao.getClosedCases();

    }
}