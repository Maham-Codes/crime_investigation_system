package com.crimeinvestigation.system.service;

import com.crimeinvestigation.system.dao.CrimeCaseDao;
import com.crimeinvestigation.system.dto.AmberAlertDTO;
import com.crimeinvestigation.system.enums.CaseStatus;
import com.crimeinvestigation.system.enums.Crimetypes;
import com.crimeinvestigation.system.exception.ResourceNotFoundException;
import com.crimeinvestigation.system.model.CrimeCase;
import com.crimeinvestigation.system.model.Evidence;
import com.crimeinvestigation.system.model.User;
import com.crimeinvestigation.system.repository.CrimeCaseRepository;
import com.crimeinvestigation.system.repository.EvidenceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CrimeCaseService {

    @Autowired
    private CrimeCaseRepository crimeCaseRepo;

    @Autowired
    private CrimeCaseDao crimeCaseDao; // add this

    @Autowired
    private EvidenceRepository evidenceRepo;

    public void reportCrime(CrimeCase crimeCase) {
        crimeCaseRepo.save(crimeCase); // Assuming you have a JPA repository
    }
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

    public List<CrimeCase> getAmberAlertCases() {
        List<CrimeCase> allCases = crimeCaseRepo.findAll();

        return allCases.stream()
                .filter(caseObj -> caseObj.getCrimeType().getType().equals(Crimetypes.kidnapping))
                .filter(caseObj -> caseObj.getCaseStatus() == CaseStatus.open)
                .filter(caseObj -> {
                    if (caseObj.getReportedBy() == null || caseObj.getReportedBy().getDob() == null) return false;
                    return Period.between(caseObj.getReportedBy().getDob(), LocalDate.now()).getYears() < 18;
                })
                .collect(Collectors.toList());
    }

    public List<AmberAlertDTO> getAmberAlerts() {
        List<CrimeCase> allCases = crimeCaseRepo.findAll();

        return allCases.stream()
                .filter(c -> c.getReportedBy() != null)
                .filter(c -> c.getReportedBy().getAge() < 18)
                .filter(c -> c.getCrimeType().getType() == Crimetypes.kidnapping)
                .filter(c -> c.getCaseStatus() == CaseStatus.current || c.getCaseStatus() == CaseStatus.open)
                .map(this::mapToAmberAlertDTO)
                .collect(Collectors.toList());
    }

    private AmberAlertDTO mapToAmberAlertDTO(CrimeCase crimeCase) {
        User user = crimeCase.getReportedBy();
        AmberAlertDTO dto = new AmberAlertDTO();

        dto.setCaseId(crimeCase.getCaseID());
        dto.setCrimeType(crimeCase.getCrimeType().getType().name());
        dto.setLocation(crimeCase.getLocation());
        dto.setDescription(crimeCase.getDescription());

        String fullName = user.getFirstName() + " " +
                (user.getMidName() != null ? user.getMidName() + " " : "") +
                user.getLastName();
        dto.setReportedByName(fullName.trim());

        dto.setAge(user.getAge());
        dto.setDateTime(crimeCase.getDateTime());
        dto.setCaseStatus(crimeCase.getCaseStatus());

        return dto;
    }

}

