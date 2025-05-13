package com.crimeinvestigation.system.service;

import com.crimeinvestigation.system.helper.PrivacyHelper;
import com.crimeinvestigation.system.model.Criminal;
import com.crimeinvestigation.system.model.User;
import com.crimeinvestigation.system.repository.CriminalRepository;
import com.crimeinvestigation.system.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CriminalService {

    @Autowired
    private CriminalRepository criminalRepository;

    public List<Criminal> getAll() {
        return criminalRepository.findAll();
    }

    public Criminal getById(int id) {
        return criminalRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Criminal not found with id: " + id));
    }

    public Criminal save(Criminal criminal) {
        // TODO: Validate criminal data before saving
        return criminalRepository.save(criminal);
    }

    public void delete(int id) {
        if (!criminalRepository.existsById(id)) {
            throw new ResourceNotFoundException("Criminal not found with id: " + id);
        }
        // TODO: Check if the criminal is linked to active cases before deleting
        criminalRepository.deleteById(id);
    }

    public Criminal update(int id, Criminal updated) {
        Criminal existing = getById(id);

        // TODO: Add audit logging for changes made to criminal record
        existing.setCrimetypes(updated.getCrimetypes());
        existing.setCurrentStatus(updated.getCurrentStatus());
        existing.setNationality(updated.getNationality());
        existing.setReputation(updated.getReputation());

        return criminalRepository.save(existing);
    }

    // TODO: Add method to fetch criminals by crime type
    // public List<Criminal> getByCrimeType(Crimetypes type) { ... }

    // TODO: Add method to link/unlink criminals to/from crime cases if @ManyToMany is enabled

    public Criminal getCriminalWithPrivacy(int id) {
        Criminal criminal = getById(id); // Assume you fetch it from DB

        // Use PrivacyHelper to mask if it's sensitive
        return PrivacyHelper.processIfSensitive(criminal, PrivacyHelper.maskCriminalFields());
    }
}