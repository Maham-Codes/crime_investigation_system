package com.crimeinvestigation.system.controller;

import com.crimeinvestigation.system.repository.CriminalRepository;
import com.crimeinvestigation.system.model.Criminal;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/criminals")
public class CriminalController {

    private final CriminalRepository criminalRepository;

    // Constructor to inject the CriminalRepository dependency
    public CriminalController(CriminalRepository criminalRepository) {
        this.criminalRepository = criminalRepository;
    }

    // Get all criminals
    @GetMapping
    public List<Criminal> getAllCriminals() {
        return criminalRepository.findAll();
    }

    // Get criminal by ID
    @GetMapping("/{id}")
    public Optional<Criminal> getCriminalById(@PathVariable int id) {
        return criminalRepository.findById(id);
    }

    // Create new criminal
    @PostMapping
    public Criminal addCriminal(@RequestBody Criminal criminal) {
        return criminalRepository.save(criminal);
    }

    // Update criminal information
    @PutMapping("/{id}")
    public Criminal updateCriminal(@PathVariable int id, @RequestBody Criminal criminal) {
        if (criminalRepository.existsById(id)) {
            criminal.setCriminalID(id);  // Assuming there's a setCriminalID method
            return criminalRepository.save(criminal);
        }
        return null; // Handle not found case
    }

    // Delete criminal by ID
    @DeleteMapping("/{id}")
    public String deleteCriminal(@PathVariable int id) {
        if (criminalRepository.existsById(id)) {
            criminalRepository.deleteById(id);
            return "Criminal deleted successfully.";
        }
        return "Criminal not found.";
    }
}


