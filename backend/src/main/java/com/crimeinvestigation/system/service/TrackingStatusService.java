package com.crimeinvestigation.system.service;

import com.crimeinvestigation.system.enums.CaseStatus;
import com.crimeinvestigation.system.exception.ResourceNotFoundException;
import com.crimeinvestigation.system.model.CrimeCase;
import com.crimeinvestigation.system.model.TrackingStatus;
import com.crimeinvestigation.system.repository.CrimeCaseRepository;
import com.crimeinvestigation.system.repository.TrackingStatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TrackingStatusService {
    @Autowired
    private TrackingStatusRepository trackingStatusRepository;

    public List<TrackingStatus> getAll() {
        return trackingStatusRepository.findAll();
    }

    public TrackingStatus getById(int id) {
        return trackingStatusRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("TrackingStatus not found with id: " + id));
    }

    public TrackingStatus save(TrackingStatus obj) {
        return trackingStatusRepository.save(obj);
    }

    public void delete(int id) {
        if (!trackingStatusRepository.existsById(id)) {
            throw new ResourceNotFoundException("TrackingStatus not found with id: " + id);
        }
        trackingStatusRepository.deleteById(id);
    }

    public TrackingStatus update(int id, TrackingStatus updatedObj) {
        TrackingStatus existing = getById(id);
        // TODO: update fields here
        return trackingStatusRepository.save(existing);
    }
    @Autowired
    private CrimeCaseRepository crimeCaseRepository;

    public CrimeCase getCaseById(Long caseId) {
        Optional<CrimeCase> optionalCrimeCase = crimeCaseRepository.findById(caseId);
        return optionalCrimeCase.orElseThrow(() -> new ResourceNotFoundException("CrimeCase not found with id: " + caseId));
    }

    public boolean updateCaseStatus(Long caseId, CaseStatus newStatus) {
        Optional<CrimeCase> crimeCaseOpt = crimeCaseRepository.findById(caseId);
        if (crimeCaseOpt.isPresent()) {
            CrimeCase crimeCase = crimeCaseOpt.get();

            // Update the status in the CrimeCase entity
            crimeCase.setCaseStatus(newStatus);
            crimeCaseRepository.save(crimeCase);

            // Create a new TrackingStatus entry
            TrackingStatus trackingStatus = new TrackingStatus();
            trackingStatus.setCaseID(crimeCase);
            trackingStatus.setUpdatedStatus(newStatus);
            trackingStatusRepository.save(trackingStatus);

            return true;
        } else {
            return false;
        }
    }
}