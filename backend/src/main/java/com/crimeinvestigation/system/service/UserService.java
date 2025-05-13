package com.crimeinvestigation.system.service;

import com.crimeinvestigation.system.helper.PrivacyHelper;
import com.crimeinvestigation.system.model.User;
import com.crimeinvestigation.system.repository.UserRepository;
import com.crimeinvestigation.system.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> getAll() {
        return userRepository.findAll();
    }

    public User getById(int id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with id: " + id));
    }

    public User save(User obj) {
        return userRepository.save(obj);
    }

    public void delete(int id) {
        if (!userRepository.existsById(id)) {
            throw new ResourceNotFoundException("User not found with id: " + id);
        }
        userRepository.deleteById(id);
    }

    public User update(int id, User updatedObj) {
        User existing = getById(id);
        // TODO: update fields here
        return userRepository.save(existing);
    }

    public User getUserWithPrivacy(int id) {
        User user = getById(id); // Assume you fetch it from DB

        // Use PrivacyHelper to mask if it's sensitive
        return PrivacyHelper.processIfSensitive(user, PrivacyHelper.maskUserFields());
    }
}
