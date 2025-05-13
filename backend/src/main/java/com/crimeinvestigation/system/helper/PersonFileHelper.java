package com.crimeinvestigation.system.helper;

import com.crimeinvestigation.system.model.Person;

import java.io.*;

public class PersonFileHelper {

    public static void saveToFile(Person person, String filename) throws IOException {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(filename))) {
            out.writeObject(person);
        }
    }

    public static Person readFromFile(String filename) throws IOException, ClassNotFoundException {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(filename))) {
            return (Person) in.readObject();
        }
    }
}
