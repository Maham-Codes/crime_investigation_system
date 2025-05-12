package com.crimeinvestigation.system.service;

import com.crimeinvestigation.system.model.Evidence;
import com.crimeinvestigation.system.repository.EvidenceRepository;
import com.crimeinvestigation.system.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EvidenceService {

    @Autowired
    private EvidenceRepository evidenceRepository;

    public List<Evidence> getAll() {
        return evidenceRepository.findAll();
    }

    public Evidence getById(int id) {
        return evidenceRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Evidence not found with id: " + id));
    }

    public Evidence save(Evidence obj) {
        return evidenceRepository.save(obj);
    }

    public void delete(int id) {
        if (!evidenceRepository.existsById(id)) {
            throw new ResourceNotFoundException("Evidence not found with id: " + id);
        }
        evidenceRepository.deleteById(id);
    }

    public Evidence update(int id, Evidence updatedObj) {
        Evidence existing = getById(id);
        // TODO: update fields here
        return evidenceRepository.save(existing);
    }
}
