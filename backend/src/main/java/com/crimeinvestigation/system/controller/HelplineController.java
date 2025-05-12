package com.crimeinvestigation.system.controller;

import com.crimeinvestigation.system.model.Helpline;
import com.crimeinvestigation.system.service.HelplineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/helplines")
public class HelplineController {

    private final HelplineService helplineService;

    @Autowired
    public HelplineController(HelplineService helplineService) {
        this.helplineService = helplineService;
    }

    @GetMapping
    public List<Helpline> getAllHelplines() {
        return helplineService.getAll();
    }
}
