package com.crimeinvestigation.system.service;

import com.crimeinvestigation.system.dao.CaseTrackingDao;

public class CaseTrackingService {
    private final CaseTrackingDao dao = new CaseTrackingDao();

    public void displayCasesWithAboveAverageUpdates() {
        dao.getCasesWithAboveAverageUpdates();
    }
}