package com.crimeinvestigation.system.service;

import com.crimeinvestigation.system.model.Criminal;
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

    public Criminal getById(Long id) {
        return criminalRepository.findById(Math.toIntExact(id))
                .orElseThrow(() -> new ResourceNotFoundException("Criminal not found with id: " + id));
    }

    public Criminal save(Criminal criminal) {
        // TODO: Validate criminal data before saving
        return criminalRepository.save(criminal);
    }

    public void delete(Long id) {

        if (!criminalRepository.existsById(Math.toIntExact(id))) {
            throw new ResourceNotFoundException("Criminal not found with id: " + id);
        }
        // TODO: Check if the criminal is linked to active cases before deleting
        criminalRepository.deleteById(Math.toIntExact(id));
    }

    public Criminal update(Long id, Criminal updated) {
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
}