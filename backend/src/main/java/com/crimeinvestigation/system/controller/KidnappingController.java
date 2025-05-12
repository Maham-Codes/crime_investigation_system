
package com.crimeinvestigation.system.controller;

import com.crimeinvestigation.system.model.Kidnapping;
import com.crimeinvestigation.system.service.KidnappingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

        import java.util.List;

@RestController
@RequestMapping("/api/kidnapping")
public class KidnappingController {

    private final KidnappingService service;

    @Autowired
    public KidnappingController(KidnappingService service) {
        this.service = service;
    }

    @GetMapping
    public List<Kidnapping> getAllKidnappingCases() {
        return service.getAll();
    }

    @PostMapping
    public Kidnapping addKidnappingCase(@RequestBody Kidnapping kidnapping) {
        return service.add(kidnapping);
    }

    @PutMapping("/{id}")
    public Kidnapping updateKidnappingCase(@PathVariable int id, @RequestBody Kidnapping updated) {
        return service.update(id, updated);
    }

    @DeleteMapping("/{id}")
    public String deleteKidnapping(@PathVariable int id) {
        boolean deleted = service.delete(id);
        return deleted ? "Kidnapping record deleted successfully." : "Kidnapping record not found.";
    }
}
