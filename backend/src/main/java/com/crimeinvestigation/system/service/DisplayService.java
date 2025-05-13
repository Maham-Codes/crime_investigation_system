package com.crimeinvestigation.system.service;

import com.crimeinvestigation.system.interfaces.Displayable;
import org.springframework.stereotype.Service;

import java.util.List;

//using the Displayable interface here
@Service
public class DisplayService {
    public void printAllDetails(List<Displayable> items) {
        for (Displayable item : items) {
            item.display();
        }
    }
}
