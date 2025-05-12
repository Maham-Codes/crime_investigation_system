package com.crimeinvestigation.system.service;

import com.crimeinvestigation.system.exception.ResourceNotFoundException;
import com.crimeinvestigation.system.model.LawsAndPunishments;
import com.crimeinvestigation.system.repository.LawsAndPunishmentsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LawsAndPunishmentsService {

    @Autowired
    private LawsAndPunishmentsRepository lawsAndPunishmentsRepository;

    public List<LawsAndPunishments> getAll() {
        return lawsAndPunishmentsRepository.findAll();
    }

    public LawsAndPunishments getById(String id) {
        return lawsAndPunishmentsRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("LawsAndPunishments not found with id: " + id));
    }

    public LawsAndPunishments save(LawsAndPunishments obj) {
        return lawsAndPunishmentsRepository.save(obj);
    }

    public void delete(String id) {
        if (!lawsAndPunishmentsRepository.existsById(id)) {
            throw new ResourceNotFoundException("LawsAndPunishments not found with id: " + id);
        }
        lawsAndPunishmentsRepository.deleteById(id);
    }

    public LawsAndPunishments update(String id, LawsAndPunishments updatedObj) {
        LawsAndPunishments existing = getById(id);
        // TODO: update fields here
        return lawsAndPunishmentsRepository.save(existing);
    }
}
