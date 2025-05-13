package com.crimeinvestigation.system.controller;

import com.crimeinvestigation.system.dto.CaseStatusUpdateDTO;
import com.crimeinvestigation.system.service.TrackingStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/investigator")
public class InvestigatorController {

    @Autowired
    private TrackingStatusService trackingStatusService;

    @PutMapping("/update-status")
    public ResponseEntity<String> updateCaseStatus(@RequestBody CaseStatusUpdateDTO statusUpdateDTO) {
        boolean success = trackingStatusService.updateCaseStatus(statusUpdateDTO.getCaseId(), statusUpdateDTO.getNewStatus());
        if (success) {
            return ResponseEntity.ok("Case status updated successfully.");
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
