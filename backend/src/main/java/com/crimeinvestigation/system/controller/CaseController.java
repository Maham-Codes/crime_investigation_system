package com.crimeinvestigation.system.controller;

import com.crimeinvestigation.system.dao.CrimeCaseDao;
import com.crimeinvestigation.system.service.CaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/cases")
public class CaseController {

    @Autowired
    private CaseService caseService;

    @GetMapping("/closed")
    public List<Map<String, Object>> getClosedCases() {
        return caseService.getClosedCases(); // call service, not DAO directly
    }
}

