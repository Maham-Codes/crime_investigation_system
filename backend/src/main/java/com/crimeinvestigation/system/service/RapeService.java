package com.crimeinvestigation.system.service;

import com.crimeinvestigation.system.model.Rape;
import com.crimeinvestigation.system.repository.RapeRepository;
import com.crimeinvestigation.system.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RapeService {

    @Autowired
    private RapeRepository sH_and_RapeRepository;

    public List<Rape> getAll() {
        return sH_and_RapeRepository.findAll();
    }

    public Rape getById(int id) {
        return sH_and_RapeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("SH_and_Rape not found with id: " + id));
    }

    public Rape save(Rape obj) {
        return sH_and_RapeRepository.save(obj);
    }

    public void delete(int id) {
        if (!sH_and_RapeRepository.existsById(id)) {
            throw new ResourceNotFoundException("SH_and_Rape not found with id: " + id);
        }
        sH_and_RapeRepository.deleteById(id);
    }

    public Rape update(int id, Rape updatedObj) {
        Rape existing = getById(id);
        // TODO: update fields here
        return sH_and_RapeRepository.save(existing);
    }
}
