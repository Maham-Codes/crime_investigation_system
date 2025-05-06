package com.crimeinvestigation.system.service;

import com.crimeinvestigation.system.dto.InvestigatorSignupRequest;
import com.crimeinvestigation.system.dto.UserSignupRequest;
import com.crimeinvestigation.system.model.Investigator;
import com.crimeinvestigation.system.model.User;
import com.crimeinvestigation.system.repository.InvestigatorRepository;
import com.crimeinvestigation.system.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthService {

    @Autowired
    private InvestigatorRepository investigatorRepo;

    @Autowired
    private UserRepository userRepo;

    public Investigator registerInvestigator(InvestigatorSignupRequest request) {
        Investigator inv = new Investigator();
        inv.setName(request.name);
        inv.setFatherName(request.fatherName);
        inv.setContactNumber(request.contactNumber);
        inv.setDOB(request.dob);
        inv.setOccupation(request.occupation);
        inv.setCNIC(request.cnic);
        inv.setPersonID(request.personId);
        inv.setGender(String.valueOf(request.inv_gender));
        inv.setBand(request.rank);
        inv.setNoOfCurrentCases(request.noOfCurrentCases);
        inv.setSolvedCases(request.solvedCases);
        inv.setEmail(request.email);
        inv.setPassword(request.password);  // 🔐 In production, encrypt this!
        inv.setSpecialization(request.specialization);
        return investigatorRepo.save(inv);
    }

    public User registerUser(UserSignupRequest request) {
        User user = new User();
        user.setName(request.fullName);
        user.setFatherName(request.fatherName);
        user.setContactNumber(request.contactNumber);
        user.setDOB(request.dob);
        user.setOccupation(request.occupation);
        user.setCNIC(request.CNICNumber);
        user.setPersonID(request.personId);
        user.setGender(String.valueOf(request.user_gender));
        user.setEmail(request.email);
        user.setPassword(request.password);
        user.setRole(request.role);
        return userRepo.save(user);
    }

    public Investigator loginInvestigator(String email, String password) {
        Optional<Investigator> optional = investigatorRepo.findByEmail(email);
        return optional.filter(inv -> inv.getPassword().equals(password)).orElse(null);
    }

    public User loginUser(String email, String password) {
        Optional<User> optional = userRepo.findByEmail(email);
        return optional.filter(user -> user.getPassword().equals(password)).orElse(null);
    }
}

