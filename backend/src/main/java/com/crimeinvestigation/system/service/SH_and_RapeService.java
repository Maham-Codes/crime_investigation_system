package com.crimeinvestigation.system.service;

import com.crimeinvestigation.system.model.SH_and_Rape;
import com.crimeinvestigation.system.repository.SHAndRapeRepository;
import com.crimeinvestigation.system.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SH_and_RapeService {

    @Autowired
    private SHAndRapeRepository sH_and_RapeRepository;

    public List<SH_and_Rape> getAll() {
        return sH_and_RapeRepository.findAll();
    }

    public SH_and_Rape getById(int id) {
        return sH_and_RapeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("SH_and_Rape not found with id: " + id));
    }

    public SH_and_Rape save(SH_and_Rape obj) {
        return sH_and_RapeRepository.save(obj);
    }

    public void delete(int id) {
        if (!sH_and_RapeRepository.existsById(id)) {
            throw new ResourceNotFoundException("SH_and_Rape not found with id: " + id);
        }
        sH_and_RapeRepository.deleteById(id);
    }

    public SH_and_Rape update(int id, SH_and_Rape updatedObj) {
        SH_and_Rape existing = getById(id);
        // TODO: update fields here
        return sH_and_RapeRepository.save(existing);
    }
}
