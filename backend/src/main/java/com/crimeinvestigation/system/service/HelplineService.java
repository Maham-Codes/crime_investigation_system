package com.crimeinvestigation.system.service;

import com.crimeinvestigation.system.model.Helpline;
import com.crimeinvestigation.system.repository.HelplineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HelplineService {

    private final HelplineRepository helplineRepository;

    @Autowired
    public HelplineService(HelplineRepository helplineRepository) {
        this.helplineRepository = helplineRepository;
    }

    public List<Helpline> getAllHelplines() {
        return helplineRepository.findAll(); // This fetches all helpline records from DB
    }
}

