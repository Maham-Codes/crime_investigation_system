package com.crimeinvestigation.system.service;

import com.crimeinvestigation.system.exception.ResourceNotFoundException;
import com.crimeinvestigation.system.repository.CrimeTypeRepository;
import com.crimeinvestigation.system.model.CrimeType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CrimeTypeService {

    @Autowired
    private CrimeTypeRepository crimeTypeRepository;

    public List<CrimeType> getAll() {
        return crimeTypeRepository.findAll();
    }

    public CrimeType getById(Long id) {
        return crimeTypeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("CrimeType not found with id: " + id));
    }

    public CrimeType save(CrimeType crimeType) {
        return crimeTypeRepository.save(crimeType);
    }

    public void delete(Long id) {
        if (!crimeTypeRepository.existsById(id)) {
            throw new ResourceNotFoundException("CrimeType not found with id: " + id);
        }
        crimeTypeRepository.deleteById(id);
    }

    public CrimeType update(Long id, CrimeType updated) {
        CrimeType existing = getById(id);
        existing.setType(updated.getType());
        return crimeTypeRepository.save(existing);
    }

    public void displayAllCrimeTypes() {
        List<CrimeType> types = crimeTypeRepository.findAll();
        if (types.isEmpty()) {
            System.out.println("No crime types found.");
        } else {
            types.forEach(type -> System.out.println(type.toString()));
        }
    }
}
