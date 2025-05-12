package com.crimeinvestigation.system.service;

import com.crimeinvestigation.system.model.Murder;
import com.crimeinvestigation.system.repository.MurderRepository;
import com.crimeinvestigation.system.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MurderService {

    @Autowired
    private MurderRepository murderRepository;

    public List<Murder> getAll() {
        return murderRepository.findAll();
    }

    public Murder getById(Long id) {
        return murderRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Murder not found with id: " + id));
    }

    public Murder save(Murder obj) {
        return murderRepository.save(obj);
    }

    public void delete(Long id) {
        if (!murderRepository.existsById(id)) {
            throw new ResourceNotFoundException("Murder not found with id: " + id);
        }
        murderRepository.deleteById(id);
    }

    public Murder update(Long id, Murder updatedObj) {
        Murder existing = getById(id);
        // TODO: update fields here
        return murderRepository.save(existing);
    }
}
