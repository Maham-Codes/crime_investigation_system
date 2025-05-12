package com.crimeinvestigation.system.service;

import com.crimeinvestigation.system.model.CyberCrime;
import com.crimeinvestigation.system.repository.CyberCrimeRepository;
import com.crimeinvestigation.system.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CyberCrimeService {

    @Autowired
    private CyberCrimeRepository cyberCrimeRepository;

    public List<CyberCrime> getAll() {
        return cyberCrimeRepository.findAll();
    }

    public CyberCrime getById(Long id) {
        return cyberCrimeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("CyberCrime not found with id: " + id));
    }

    public CyberCrime save(CyberCrime obj) {
        return cyberCrimeRepository.save(obj);
    }

    public void delete(Long id) {
        if (!cyberCrimeRepository.existsById(id)) {
            throw new ResourceNotFoundException("CyberCrime not found with id: " + id);
        }
        cyberCrimeRepository.deleteById(id);
    }

    public CyberCrime update(Long id, CyberCrime updatedObj) {
        CyberCrime existing = getById(id);
        // TODO: update fields here
        return cyberCrimeRepository.save(existing);
    }
}

