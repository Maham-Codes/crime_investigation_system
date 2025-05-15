package com.crimeinvestigation.system.controller;

import com.crimeinvestigation.system.dto.AmberAlertDTO;
import com.crimeinvestigation.system.dto.ReportCrimeRequestDto; // <-- IMPORT DTO
import com.crimeinvestigation.system.model.CrimeCase;
import com.crimeinvestigation.system.service.CrimeCaseService;
import com.crimeinvestigation.system.exception.ResourceNotFoundException; // <-- IMPORT
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/cases") // Base path for case-related endpoints
public class CrimeCaseController {

    @Autowired
    private CrimeCaseService caseService;

    @PostMapping("/report")
    public ResponseEntity<?> reportCrime(@RequestBody ReportCrimeRequestDto reportRequestDto) {
        try {
            System.out.println("Received POST /cases/report with DTO: " + reportRequestDto);
            // CORRECTED METHOD NAME HERE:
            CrimeCase reportedCase = caseService.reportCrimeFromDto(reportRequestDto);
            return ResponseEntity.status(HttpStatus.CREATED).body(reportedCase);
        } catch (ResourceNotFoundException e) {
            System.err.println("Resource not found during crime report: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        } catch (IllegalArgumentException e) { // Ensure you have this custom exception or use a standard one
            System.err.println("Invalid argument during crime report: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        } catch (Exception e) {
            System.err.println("Unexpected error during crime report: " + e.getMessage());
            e.printStackTrace(); // Log for server-side debugging
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred while reporting the crime.");
        }
    }

    // Make sure these methods are uncommented if you need them
    @GetMapping("/closed")
    public List<Map<String, Object>> getClosedCases() {
        return caseService.getClosedCases();
    }

    @GetMapping("/amber-alerts")
    public ResponseEntity<List<AmberAlertDTO>> getAmberAlerts() {
        List<AmberAlertDTO> alerts = caseService.getAmberAlerts();
        return ResponseEntity.ok(alerts);
    }
}