package com.crimeinvestigation.system.service;

import com.crimeinvestigation.system.model.LawsAndPunishments;
import com.crimeinvestigation.system.repository.LawsAndPunishmentsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LawsAndPunishmentsService {

    private final LawsAndPunishmentsRepository repository;

    @Autowired
    public LawsAndPunishmentsService(LawsAndPunishmentsRepository repository) {
        this.repository = repository;
    }

    public List<LawsAndPunishments> getAllLaws() {
        return repository.findAll(); // Fetch from DB
    }
}
