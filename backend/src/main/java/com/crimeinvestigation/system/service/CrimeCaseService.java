package com.crimeinvestigation.system.service;

import com.crimeinvestigation.system.dao.CrimeCaseDao;
import com.crimeinvestigation.system.enums.CaseStatus;
import com.crimeinvestigation.system.enums.Crimetypes;
import com.crimeinvestigation.system.exception.ResourceNotFoundException;
import com.crimeinvestigation.system.model.CrimeCase;
import com.crimeinvestigation.system.model.Evidence;
import com.crimeinvestigation.system.repository.CrimeCaseRepository;
import com.crimeinvestigation.system.repository.EvidenceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class CrimeCaseService {

    @Autowired
    private CrimeCaseRepository crimeCaseRepo;

    @Autowired
    private CrimeCaseDao crimeCaseDao; // add this

    @Autowired
    private EvidenceRepository evidenceRepo;

    public List<Map<String, Object>> getClosedCases() {
        return crimeCaseDao.getClosedCases();
    }

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

    public List<CrimeCase> getAllCases() {
        return crimeCaseRepo.findAll();
    }

    public CrimeCase getCaseById(Long id) {
        return crimeCaseRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("CrimeCase not found with id: " + id));
    }

    public CrimeCase saveCase(CrimeCase crimeCase) {
        return crimeCaseRepo.save(crimeCase);
    }

    public void deleteCase(Long id) {
        if (!crimeCaseRepo.existsById(id)) {
            throw new ResourceNotFoundException("CrimeCase not found with id: " + id);
        }
        crimeCaseRepo.deleteById(id);
    }

    public CrimeCase updateCase(Long id, CrimeCase updatedCase) {
        CrimeCase existing = getCaseById(id);

        existing.setDateTime(updatedCase.getDateTime());
        existing.setLocation(updatedCase.getLocation());
        existing.setDescription(updatedCase.getDescription());
        existing.setCrimeType(updatedCase.getCrimeType());
        existing.setCaseStatus(updatedCase.getCaseStatus());
        existing.setInvestigatorID(updatedCase.getInvestigatorID());

        return crimeCaseRepo.save(existing);
    }

    public void addEvidenceToCase(Long caseId, Evidence evidence) {
        CrimeCase crimeCase = crimeCaseRepo.findById(caseId).orElseThrow();
        evidence.setCrimeCase(crimeCase);
        evidenceRepo.save(evidence);
    }
}

