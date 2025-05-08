package com.crimeinvestigation.system.service;

import com.crimeinvestigation.system.enums.CaseStatus;
import com.crimeinvestigation.system.model.CrimeCase;
import com.crimeinvestigation.system.repository.CrimeCaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CaseService {

    @Autowired
    private CrimeCaseRepository crimeCaseRepo;

    public CrimeCase updateCaseStatus(Long caseId, CaseStatus newStatus) {
        Optional<CrimeCase> optionalCase = crimeCaseRepo.findById(caseId);
        if (optionalCase.isPresent()) {
            CrimeCase crimeCase = optionalCase.get();
            crimeCase.setCaseStatus(newStatus);
            return crimeCaseRepo.save(crimeCase);
        } else {
            throw new RuntimeException("Case not found");
        }
    }
}
