package com.crimeinvestigation.system.service;

import com.crimeinvestigation.system.dao.CaseTrackingDao;
import org.springframework.stereotype.Service;

@Service
public class CaseTrackingService {
    private final CaseTrackingDao dao = new CaseTrackingDao();

    public void displayCasesWithAboveAverageUpdates() {
        dao.getCasesWithAboveAverageUpdates();
    }
}