package com.crimeinvestigation.system.service;

import com.crimeinvestigation.system.exception.ResourceNotFoundException;
import com.crimeinvestigation.system.model.CrimeCase;
import com.crimeinvestigation.system.repository.CrimeCaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CrimeCaseService {

    @Autowired
    private CrimeCaseRepository crimeCaseRepository;

    public List<CrimeCase> getAll() {
        return crimeCaseRepository.findAll();
    }

    public CrimeCase getById(Long id) {
        return crimeCaseRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("CrimeCase not found with id: " + id));
    }

    public CrimeCase save(CrimeCase obj) {
        return crimeCaseRepository.save(obj);
    }

    public void delete(Long id) {
        if (!crimeCaseRepository.existsById(id)) {
            throw new ResourceNotFoundException("CrimeCase not found with id: " + id);
        }
        crimeCaseRepository.deleteById(id);
    }

    public CrimeCase update(Long id, CrimeCase updatedObj) {
        CrimeCase existing = getById(id);
        // TODO: update fields here
        return crimeCaseRepository.save(existing);
    }
}