package com.crimeinvestigation.system.service;

import com.crimeinvestigation.system.model.Theft;
import com.crimeinvestigation.system.repository.TheftRepository;
import com.crimeinvestigation.system.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TheftService {

    @Autowired
    private TheftRepository theftRepository;

    public List<Theft> getAll() {
        return theftRepository.findAll();
    }

    public Theft getById(int id) {
        return theftRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Theft not found with id: " + id));
    }

    public Theft save(Theft obj) {
        return theftRepository.save(obj);
    }

    public void delete(int id) {
        if (!theftRepository.existsById(id)) {
            throw new ResourceNotFoundException("Theft not found with id: " + id);
        }
        theftRepository.deleteById(id);
    }

    public Theft update(int id, Theft updatedObj) {
        Theft existing = getById(id);
        // TODO: update fields here
        return theftRepository.save(existing);
    }
}
