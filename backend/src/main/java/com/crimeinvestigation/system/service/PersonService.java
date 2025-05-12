package com.crimeinvestigation.system.service;

import com.crimeinvestigation.system.model.Person;
import com.crimeinvestigation.system.repository.PersonRepository;
import com.crimeinvestigation.system.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {

    @Autowired
    private PersonRepository personRepository;

    public List<Person> getAll() {
        return personRepository.findAll();
    }

    public Person getById(int id) {
        return personRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Person not found with id: " + id));
    }

    public Person save(Person obj) {
        return personRepository.save(obj);
    }

    public void delete(int id) {
        if (!personRepository.existsById(id)) {
            throw new ResourceNotFoundException("Person not found with id: " + id);
        }
        personRepository.deleteById(id);
    }

    public Person update(int id, Person updatedObj) {
        Person existing = getById(id);
        // TODO: update fields here
        return personRepository.save(existing);
    }
}
