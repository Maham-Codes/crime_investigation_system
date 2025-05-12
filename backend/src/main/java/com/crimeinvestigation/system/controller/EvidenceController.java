package com.crimeinvestigation.system.controller;

import com.crimeinvestigation.system.repository.EvidenceRepository;
import com.crimeinvestigation.system.model.Evidence;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/evidence")
public class EvidenceController {
    private final EvidenceRepository evidenceRepository;

    public EvidenceController(EvidenceRepository evidenceRepository) {
        this.evidenceRepository = evidenceRepository;
    }

    @GetMapping
    public List<Evidence> getAllEvidence() {
        return evidenceRepository.findAll();
    }

    @PostMapping
    public Evidence addEvidence(@RequestBody Evidence evidence) {
        return evidenceRepository.save(evidence);
    }

    /*@PutMapping("/{id}")
    public Evidence updateEvidence(@PathVariable long id, @RequestBody Evidence evidence) {
        if (evidenceRepository.existsById(id)) {
            evidence.setEvidenceID(id);
            return evidenceRepository.save(evidence);
        }
        return null; // Handle the case when the evidence is not found
    }*/

    @DeleteMapping("/{id}")
    public String deleteEvidence(@PathVariable int id) {
        if (evidenceRepository.existsById(id)) {
            evidenceRepository.deleteById(id);
            return "Evidence deleted successfully.";
        }
        return "Evidence not found.";
    }
}


