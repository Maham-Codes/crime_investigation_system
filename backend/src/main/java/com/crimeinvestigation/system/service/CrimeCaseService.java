package com.crimeinvestigation.system.service;

import com.crimeinvestigation.system.dao.CrimeCaseDao; // Keep if used for other methods
import com.crimeinvestigation.system.dto.AmberAlertDTO;
import com.crimeinvestigation.system.dto.ReportCrimeRequestDto; // Import the new DTO
import com.crimeinvestigation.system.enums.CaseStatus;
import com.crimeinvestigation.system.enums.Crimetypes;
import com.crimeinvestigation.system.exception.ResourceNotFoundException;
import com.crimeinvestigation.system.model.CrimeCase;
import com.crimeinvestigation.system.model.CrimeType; // Import CrimeType
import com.crimeinvestigation.system.model.Evidence;
import com.crimeinvestigation.system.model.User;     // Import User
import com.crimeinvestigation.system.repository.CrimeCaseRepository;
import com.crimeinvestigation.system.repository.CrimeTypeRepository; // Import CrimeTypeRepository
import com.crimeinvestigation.system.repository.EvidenceRepository;
import com.crimeinvestigation.system.repository.UserRepository;      // Import UserRepository
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional; // For transactional operations

import java.time.LocalDate;
import java.time.LocalDateTime; // Import LocalDateTime
import java.time.Period;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CrimeCaseService {

    private final CrimeCaseRepository crimeCaseRepository;
    private final CrimeTypeRepository crimeTypeRepository; // To fetch CrimeType
    private final UserRepository userRepository;         // To fetch User (reporter)
    private final CrimeCaseDao crimeCaseDao;             // Keep if used for getClosedCases
    private final EvidenceRepository evidenceRepository;   // Keep if used for addEvidenceToCase

    @Autowired
    public CrimeCaseService(
            CrimeCaseRepository crimeCaseRepository,
            CrimeTypeRepository crimeTypeRepository,
            UserRepository userRepository,
            CrimeCaseDao crimeCaseDao,
            EvidenceRepository evidenceRepository) {
        this.crimeCaseRepository = crimeCaseRepository;
        this.crimeTypeRepository = crimeTypeRepository;
        this.userRepository = userRepository;
        this.crimeCaseDao = crimeCaseDao;
        this.evidenceRepository = evidenceRepository;
    }

    // OLD reportCrime - can be removed or refactored if DTO approach is preferred
    // public void reportCrime(CrimeCase crimeCase) {
    //    crimeCaseRepository.save(crimeCase);
    // }

    @Transactional // Good practice for operations involving multiple repository calls
    public CrimeCase reportCrimeFromDto(ReportCrimeRequestDto reportDto) {
        // 1. Fetch the reporting User by email
        User reporter = userRepository.findByEmail(reportDto.getReportedByUserEmail())
                .orElseThrow(() -> {
                    System.err.println("Service Layer: User (reporter) not found with email: " + reportDto.getReportedByUserEmail());
                    return new ResourceNotFoundException("User (reporter) not found with email: " + reportDto.getReportedByUserEmail());
                });

        // 2. Fetch the CrimeType by ID
        CrimeType crimeTypeEntity = crimeTypeRepository.findById(reportDto.getCrimeTypeId())
                .orElseThrow(() -> {
                    System.err.println("Service Layer: CrimeType not found with ID: " + reportDto.getCrimeTypeId());
                    return new ResourceNotFoundException("CrimeType not found with ID: " + reportDto.getCrimeTypeId());
                });

        // 3. Create and populate the CrimeCase entity
        CrimeCase newCrimeCase = new CrimeCase();
        newCrimeCase.setLocation(reportDto.getLocation());
        newCrimeCase.setDescription(reportDto.getDescription());
        newCrimeCase.setCrimeType(crimeTypeEntity);
        newCrimeCase.setReportedBy(reporter);
        newCrimeCase.setDateTime(LocalDateTime.now()); // Set current date and time
        newCrimeCase.setCaseStatus(CaseStatus.open);   // Default status for new cases
        newCrimeCase.setCCTVPresence(reportDto.getCctvPresence() != null ? reportDto.getCctvPresence() : false); // Default to false if null

        // Any other default fields for a new CrimeCase can be set here

        // 4. Save the new CrimeCase
        return crimeCaseRepository.save(newCrimeCase);
    }


    public List<Map<String, Object>> getClosedCases() {
        return crimeCaseDao.getClosedCases();
    }

    @Transactional
    public CrimeCase updateCaseStatus(Long caseId, CaseStatus newStatus) {
        CrimeCase crimeCase = crimeCaseRepository.findById(caseId)
                .orElseThrow(() -> new ResourceNotFoundException("Case not found with ID: " + caseId));
        crimeCase.setCaseStatus(newStatus);
        return crimeCaseRepository.save(crimeCase);
        // Note: Your TrackingStatus logic might also need to be called here if it's separate
    }

    public List<CrimeCase> getAllCases() {
        return crimeCaseRepository.findAll();
    }

    public CrimeCase getCaseById(Long id) {
        return crimeCaseRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("CrimeCase not found with id: " + id));
    }

    // Renamed to avoid conflict with JpaRepository's save
    public CrimeCase createCase(CrimeCase crimeCase) {
        return crimeCaseRepository.save(crimeCase);
    }

    @Transactional
    public void deleteCase(Long id) {
        if (!crimeCaseRepository.existsById(id)) {
            throw new ResourceNotFoundException("CrimeCase not found with id: " + id);
        }
        crimeCaseRepository.deleteById(id);
    }

    @Transactional
    public CrimeCase updateCaseDetails(Long id, CrimeCase updatedCase) { // Renamed to avoid confusion
        CrimeCase existing = getCaseById(id); // This already throws if not found

        existing.setDateTime(updatedCase.getDateTime());
        existing.setLocation(updatedCase.getLocation());
        existing.setDescription(updatedCase.getDescription());
        existing.setCrimeType(updatedCase.getCrimeType());
        // CaseStatus should be updated via updateCaseStatus or a dedicated DTO
        // existing.setCaseStatus(updatedCase.getCaseStatus());
        existing.setInvestigatorID(updatedCase.getInvestigatorID());
        existing.setCCTVPresence(updatedCase.getCCTVPresence());
        // Handle other specific fields from CrimeCase subtypes if necessary,
        // though this method is on the generic CrimeCase.

        return crimeCaseRepository.save(existing);
    }

    @Transactional
    public void addEvidenceToCase(Long caseId, Evidence evidence) {
        CrimeCase crimeCase = getCaseById(caseId); // This throws if case not found
        evidence.setCrimeCase(crimeCase);
        evidenceRepository.save(evidence);
    }

    public List<AmberAlertDTO> getAmberAlerts() {
        List<CrimeCase> allCases = crimeCaseRepository.findAll();

        return allCases.stream()
                .filter(c -> c.getReportedBy() != null && c.getReportedBy().getDob() != null) // Ensure reportedBy and DOB are not null
                .filter(c -> Period.between(c.getReportedBy().getDob(), LocalDate.now()).getYears() < 18)
                .filter(c -> c.getCrimeType() != null && c.getCrimeType().getType() == Crimetypes.kidnapping)
                .filter(c -> c.getCaseStatus() == CaseStatus.unsolved || c.getCaseStatus() == CaseStatus.open)
                .map(this::mapToAmberAlertDTO)
                .collect(Collectors.toList());
    }

    private AmberAlertDTO mapToAmberAlertDTO(CrimeCase crimeCase) {
        User user = crimeCase.getReportedBy(); // Assuming reportedBy is never null due to filter above
        AmberAlertDTO dto = new AmberAlertDTO();

        dto.setCaseId(crimeCase.getCaseID());
        if (crimeCase.getCrimeType() != null && crimeCase.getCrimeType().getType() != null) {
            dto.setCrimeType(crimeCase.getCrimeType().getType().name());
        } else {
            dto.setCrimeType("Unknown");
        }
        dto.setLocation(crimeCase.getLocation());
        dto.setDescription(crimeCase.getDescription());

        String fullName = (user.getFirstName() != null ? user.getFirstName() : "") + " " +
                (user.getMidName() != null ? user.getMidName() + " " : "") +
                (user.getLastName() != null ? user.getLastName() : "");
        dto.setReportedByName(fullName.trim().isEmpty() ? "Anonymous" : fullName.trim());

        dto.setAge(user.getAge()); // getAge() handles null DOB in Person
        dto.setDateTime(crimeCase.getDateTime());
        dto.setCaseStatus(crimeCase.getCaseStatus());

        return dto;
    }
}