package com.crimeinvestigation.system.controller;

import com.crimeinvestigation.system.interfaces.Displayable;
import com.crimeinvestigation.system.model.CrimeCase;
import com.crimeinvestigation.system.model.LawsAndPunishments;
import com.crimeinvestigation.system.service.DisplayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

//using this because the display interface will be used in many classes
@RestController
public class DisplayableController {
    @Autowired
    private DisplayService displayService;

    @GetMapping("/display-all")
    public void displayAll() {
        List<Displayable> items = fetchSomeDisplayables();
        displayService.printAllDetails(items);
    }

    private List<Displayable> fetchSomeDisplayables() {
        // Fetch from DB or mock list
        return List.of(
                new LawsAndPunishments(
                        1L,
                        "Robbery",
                        "Section 378",
                        "Imprisonment up to 3 years"
                )
                /*new CrimeCase(
                        101L,
                        LocalDateTime.now(),
                        "Downtown",
                        "Stolen vehicle",
                        crimeTypeObj, // must be an existing CrimeType object
                        CaseStatus.open,
                        investigatorObj, // must be an existing Investigator object
                        investigatorObj  // assuming this is for investigatorID too
                )*/
        );
    }
}
