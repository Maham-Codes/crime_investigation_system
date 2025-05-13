package com.crimeinvestigation.system.service;

import com.crimeinvestigation.system.exception.ResourceNotFoundException;
import com.crimeinvestigation.system.model.Helpline;
import com.crimeinvestigation.system.repository.HelplineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.crimeinvestigation.system.helper.HelplineHelper;

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

    public void exportToFile() {
        List<Helpline> allHelplines = helplineRepository.findAll();
        HelplineHelper.saveToFile(allHelplines); // Calls static method
    }

    public List<Helpline> importFromFile() {
        return HelplineHelper.readFromFile(); // Calls static method
    }
}


