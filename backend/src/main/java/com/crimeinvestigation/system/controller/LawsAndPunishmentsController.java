package com.crimeinvestigation.system.controller;

import com.crimeinvestigation.system.model.LawsAndPunishments;
import com.crimeinvestigation.system.service.LawsAndPunishmentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/laws")
public class LawsAndPunishmentsController {

    private final LawsAndPunishmentsService service;

    @Autowired
    public LawsAndPunishmentsController(LawsAndPunishmentsService service) {
        this.service = service;
    }

    @GetMapping
    public List<LawsAndPunishments> getAllLaws() {
        return service.getAll();
    }


}
