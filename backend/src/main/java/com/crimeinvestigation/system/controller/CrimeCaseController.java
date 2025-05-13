package com.crimeinvestigation.system.controller;

import com.crimeinvestigation.system.model.CrimeCase;
import com.crimeinvestigation.system.service.CrimeCaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/cases")
public class CrimeCaseController {

    @Autowired
    private CrimeCaseService caseService;

    @GetMapping("/closed")
    public List<Map<String, Object>> getClosedCases() {
        return caseService.getClosedCases(); // call service, not DAO directly
    }

    @PostMapping("/report")
    public ResponseEntity<String> reportCrime(@RequestBody CrimeCase crimeCase) {
        caseService.reportCrime(crimeCase);
        return ResponseEntity.ok("Crime reported successfully.");
    }
}

