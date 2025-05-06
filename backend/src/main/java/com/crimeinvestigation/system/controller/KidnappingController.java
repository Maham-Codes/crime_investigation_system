
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
        return service.getAllKidnappingCases();
    }

    @PostMapping
    public Kidnapping addKidnappingCase(@RequestBody Kidnapping kidnapping) {
        return service.addKidnappingCase(kidnapping);
    }

    @PutMapping("/{id}")
    public Kidnapping updateKidnappingCase(@PathVariable int id, @RequestBody Kidnapping updated) {
        return service.updateKidnappingCase(id, updated);
    }

    @DeleteMapping("/{id}")
    public String deleteKidnappingCase(@PathVariable int id) {
        return service.deleteKidnappingCase(id);
    }
}
