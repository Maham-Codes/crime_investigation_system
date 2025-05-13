package com.crimeinvestigation.system.service;

import com.crimeinvestigation.system.helper.PrivacyHelper;
import com.crimeinvestigation.system.model.Investigator;
import com.crimeinvestigation.system.model.User;
import com.crimeinvestigation.system.repository.InvestigatorRepository;
import com.crimeinvestigation.system.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InvestigatorService {

    @Autowired
    private InvestigatorRepository investigatorRepository;

    public List<Investigator> getAll() {
        return investigatorRepository.findAll();
    }

    public Investigator getById(int id) {
        return investigatorRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Investigator not found with id: " + id));
    }

    public Investigator save(Investigator obj) {
        return investigatorRepository.save(obj);
    }

    public void delete(int id) {
        if (!investigatorRepository.existsById(id)) {
            throw new ResourceNotFoundException("Investigator not found with id: " + id);
        }
        investigatorRepository.deleteById(id);
    }

    public Investigator update(int id, Investigator updatedObj) {
        Investigator existing = getById(id);
        // TODO: update fields here
        return investigatorRepository.save(existing);
    }

    public Investigator getInvestigatorWithPrivacy(int id) {
        Investigator investigator = getById(id); // Assume you fetch it from DB

        // Use PrivacyHelper to mask if it's sensitive
        return PrivacyHelper.processIfSensitive(investigator, PrivacyHelper.maskInvestigatorFields());
    }
}