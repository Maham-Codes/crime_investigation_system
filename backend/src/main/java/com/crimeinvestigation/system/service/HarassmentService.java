package com.crimeinvestigation.system.service;

import com.crimeinvestigation.system.model.Harassment;
import com.crimeinvestigation.system.repository.HarassmentRepository;
import com.crimeinvestigation.system.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HarassmentService {

    @Autowired
    private HarassmentRepository harassmentRepository;

    public List<Harassment> getAll() {
        return harassmentRepository.findAll();
    }

    public Harassment getById(Long id) {
        return harassmentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Harassment not found with id: " + id));
    }

    public Harassment save(Harassment obj) {
        return harassmentRepository.save(obj);
    }

    public void delete(Long id) {
        if (!harassmentRepository.existsById(id)) {
            throw new ResourceNotFoundException("Harassment not found with id: " + id);
        }
        harassmentRepository.deleteById(id);
    }

    public Harassment update(Long id, Harassment updatedObj) {
        Harassment existing = getById(id);
        // TODO: update fields here
        return harassmentRepository.save(existing);
    }
}

