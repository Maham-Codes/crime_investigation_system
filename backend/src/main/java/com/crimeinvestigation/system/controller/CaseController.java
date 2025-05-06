package com.crimeinvestigation.system.controller;

import com.crimeinvestigation.system.enums.CaseStatus;
import com.crimeinvestigation.system.model.CrimeCase;
import com.crimeinvestigation.system.service.CaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cases")
public class CaseController {

    @Autowired
    private CaseService caseService;

    @PutMapping("/update-status/{id}")
    public ResponseEntity<?> updateCaseStatus(@PathVariable Long id, @RequestParam CaseStatus status) {
        try {
            CrimeCase updated = caseService.updateCaseStatus(id, status);
            return ResponseEntity.ok(updated);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }
}

