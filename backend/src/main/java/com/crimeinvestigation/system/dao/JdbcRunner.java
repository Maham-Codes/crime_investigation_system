package com.crimeinvestigation.system.dao;

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

        //nested Subquery
        //Find criminals who are involved in cases with poor feedback (rating 2 or below), and those cases have not been updated in tracking for over 30 days.
        LowRatedCriminalsDao lowratedcriminalsdao = new LowRatedCriminalsDao();
        lowratedcriminalsdao.getLowRatedInactiveCriminals();

    }
}