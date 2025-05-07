

package com.crimeinvestigation.system.service;

import com.crimeinvestigation.system.model.Kidnapping;
import com.crimeinvestigation.system.repository.KidnappingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@Service
public class KidnappingService {

    private final KidnappingRepository repository;

    @Autowired
    public KidnappingService(KidnappingRepository repository) {
        this.repository = repository;
    }

    public List<Kidnapping> getAllKidnappingCases() {
        return repository.findAll();
    }

    public Kidnapping addKidnappingCase(Kidnapping kidnapping) {
        return repository.save(kidnapping);
    }

    public Kidnapping updateKidnappingCase(int caseID, Kidnapping updated) {

        if (repository.existsById(caseID)) {
            updated.setCaseID(caseID);
            return repository.save(updated);
        }
        return null;
    }

    public String deleteKidnappingCase(int id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return "Kidnapping case deleted successfully.";
        }
        return "Kidnapping case not found.";
    }
}
