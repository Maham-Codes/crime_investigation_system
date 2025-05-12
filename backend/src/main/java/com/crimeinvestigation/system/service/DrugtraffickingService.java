package com.crimeinvestigation.system.service;

import com.crimeinvestigation.system.model.Drugtrafficking;
import com.crimeinvestigation.system.repository.DrugtraffickingRepository;
import com.crimeinvestigation.system.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DrugtraffickingService {

    @Autowired
    private DrugtraffickingRepository drugtraffickingRepository;

    public List<Drugtrafficking> getAll() {
        return drugtraffickingRepository.findAll();
    }

    public Drugtrafficking getById(Long id) {
        return drugtraffickingRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Drugtrafficking not found with id: " + id));
    }

    public Drugtrafficking save(Drugtrafficking obj) {
        return drugtraffickingRepository.save(obj);
    }

    public void delete(Long id) {
        if (!drugtraffickingRepository.existsById(id)) {
            throw new ResourceNotFoundException("Drugtrafficking not found with id: " + id);
        }
        drugtraffickingRepository.deleteById(id);
    }

    public Drugtrafficking update(Long id, Drugtrafficking updatedObj) {
        Drugtrafficking existing = getById(id);
        // TODO: update fields here
        return drugtraffickingRepository.save(existing);
    }
}
