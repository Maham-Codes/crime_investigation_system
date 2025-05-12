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

    public Criminal getById(int id) {
        return criminalRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Criminal not found with id: " + id));
    }

    public Criminal save(Criminal obj) {
        return criminalRepository.save(obj);
    }

    public void delete(int id) {
        if (!criminalRepository.existsById(id)) {
            throw new ResourceNotFoundException("Criminal not found with id: " + id);
        }
        criminalRepository.deleteById(id);
    }

    public Criminal update(int id, Criminal updatedObj) {
        Criminal existing = getById(id);
        // TODO: update fields here
        return criminalRepository.save(existing);
    }
}