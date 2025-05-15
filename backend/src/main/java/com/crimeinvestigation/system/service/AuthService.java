package com.crimeinvestigation.system.service;

import com.crimeinvestigation.system.dto.InvestigatorSignupRequest;
import com.crimeinvestigation.system.dto.UserSignupRequest;
import com.crimeinvestigation.system.enums.Role;
import com.crimeinvestigation.system.model.Investigator;
import com.crimeinvestigation.system.model.Person;
import com.crimeinvestigation.system.model.User;
import com.crimeinvestigation.system.repository.InvestigatorRepository;
import com.crimeinvestigation.system.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;

@Service
public class AuthService {

    @Autowired
    private InvestigatorRepository investigatorRepo;

    @Autowired
    private UserRepository userRepo;

    public Investigator registerInvestigator(InvestigatorSignupRequest request) {
        Investigator inv = new Investigator();
        inv.setFirstName(request.firstName);
        inv.setMidName(request.midName);
        inv.setLastName(request.lastName);
        inv.setFatherName(request.fatherName);
        inv.setContactNumber(request.contactNumber);
        inv.setDob(LocalDate.parse(request.dob));
        inv.setOccupation(request.occupation);
        inv.setCnic(request.cnic);
        inv.setPersonid((long) request.personId);
        inv.setGender(request.gender);
        inv.setRole(request.role);
        inv.setBand(request.rank);
        inv.setNoOfCurrentCases(request.noOfCurrentCases);
        inv.setSolvedCases(request.solvedCases);
        inv.setEmail(request.email);
        inv.setPassword(request.password);
        inv.setSpecialization(request.specialization);
        return investigatorRepo.save(inv);
    }

    public User registerUser(UserSignupRequest request) {

        User user = new User();
        user.setFirstName(request.firstName);
        user.setMidName(request.midName);
        user.setLastName(request.lastName);
        user.setFatherName(request.fatherName);
        user.setContactNumber(request.contactNumber);
        user.setDob(LocalDate.parse(request.dob));
        user.setOccupation(request.occupation);
        user.setCnic(request.cnic);
        user.setPersonid((long) request.personId);
        user.setGender(request.gender);
        user.setEmail(request.email);
        user.setUsername(request.username);
        user.setPassword(request.password);
//        System.out.println(request.role);
//        user.setRole(request.role);
        user.setRole(Role.user);
        user.setUserType(request.userType);
        return userRepo.save(user);
    }

    public Investigator loginInvestigator(String email, String password) {
        Optional<Investigator> optional = investigatorRepo.findByEmail(email);
        return optional.filter(inv -> inv.getPassword().equals(password)).orElse(null);
    }

    public User loginUser(String username, String password) {
        Optional<User> optional = userRepo.findByUsername(username);
        return optional.filter(user -> user.getPassword().equals(password)).orElse(null);
    }
}