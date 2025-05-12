package com.crimeinvestigation.system.service;

import com.crimeinvestigation.system.exception.ResourceNotFoundException;
import com.crimeinvestigation.system.model.Helpline;
import com.crimeinvestigation.system.repository.HelplineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HelplineService {

    @Autowired
    private HelplineRepository helplineRepository;

    public List<Helpline> getAll() {
        return helplineRepository.findAll();
    }

    public Helpline getById(int id) {
        return helplineRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Helpline not found with id: " + id));
    }

    public Helpline save(Helpline obj) {
        return helplineRepository.save(obj);
    }

    public void delete(int id) {
        if (!helplineRepository.existsById(id)) {
            throw new ResourceNotFoundException("Helpline not found with id: " + id);
        }
        helplineRepository.deleteById(id);
    }

    public Helpline update(int id, Helpline updatedObj) {
        Helpline existing = getById(id);
        // TODO: update fields here
        return helplineRepository.save(existing);
    }
}

