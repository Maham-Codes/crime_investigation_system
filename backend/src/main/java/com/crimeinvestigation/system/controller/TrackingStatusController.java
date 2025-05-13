package com.crimeinvestigation.system.controller;

import com.crimeinvestigation.system.model.CrimeCase;
import com.crimeinvestigation.system.service.TrackingStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/trackingstatus")
public class TrackingStatusController {

    @Autowired
    private TrackingStatusService trackingStatusService;

    @GetMapping("/{caseId}")
    public ResponseEntity<CrimeCase> trackCaseById(@PathVariable Long caseId) {
        CrimeCase crimeCase = trackingStatusService.getCaseById(caseId);
        if (crimeCase != null) {
            return ResponseEntity.ok(crimeCase);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
