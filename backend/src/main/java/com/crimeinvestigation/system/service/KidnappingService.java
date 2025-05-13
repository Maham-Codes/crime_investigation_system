

package com.crimeinvestigation.system.service;

import com.crimeinvestigation.system.exception.ResourceNotFoundException;
import com.crimeinvestigation.system.model.Kidnapping;
import com.crimeinvestigation.system.repository.KidnappingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@Service
public class KidnappingService {

    @Autowired
    private KidnappingRepository kidnappingRepository;

    public List<Kidnapping> getAll() {
        return kidnappingRepository.findAll();
    }

    public Kidnapping getById(int id) {
        return kidnappingRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Kidnapping not found with id: " + id));
    }



    public boolean delete(int id) {
        if (!kidnappingRepository.existsById(id)) {
            return false;
        }
        kidnappingRepository.deleteById(id);
        return true;
    }

    public Kidnapping add(Kidnapping kidnapping) {
        // Add any validation or default-setting logic if needed
        return kidnappingRepository.save(kidnapping);
    }

    public Kidnapping update(int id, Kidnapping updatedObj) {
        Kidnapping existing = getById(id);
        // TODO: update fields here
        return kidnappingRepository.save(existing);
    }
}
