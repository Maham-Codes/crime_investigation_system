package com.crimeinvestigation.system.service;

import com.crimeinvestigation.system.exception.ResourceNotFoundException;
import com.crimeinvestigation.system.model.TrackingStatus;
import com.crimeinvestigation.system.repository.TrackingStatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrackingServiceService {
    @Autowired
    private TrackingStatusRepository trackingStatusRepository;

    public List<TrackingStatus> getAll() {
        return trackingStatusRepository.findAll();
    }

    public TrackingStatus getById(int id) {
        return trackingStatusRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("TrackingStatus not found with id: " + id));
    }

    public TrackingStatus save(TrackingStatus obj) {
        return trackingStatusRepository.save(obj);
    }

    public void delete(int id) {
        if (!trackingStatusRepository.existsById(id)) {
            throw new ResourceNotFoundException("TrackingStatus not found with id: " + id);
        }
        trackingStatusRepository.deleteById(id);
    }

    public TrackingStatus update(int id, TrackingStatus updatedObj) {
        TrackingStatus existing = getById(id);
        // TODO: update fields here
        return trackingStatusRepository.save(existing);
    }
}