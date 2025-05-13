package com.crimeinvestigation.system.helper;

import com.crimeinvestigation.system.model.Helpline;

import java.io.*;
import java.util.List;

public class HelplineHelper {

    private static final String filename = "helplines.dat"; // Define the filename variable

    public static void saveToFile(List<Helpline> helplines) { // Made the method public and static
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            oos.writeObject(helplines);
            System.out.println("Helpline list serialized successfully.");
        } catch (IOException e) {
            System.out.println("Error while serializing helpline list.");
        }
    }

    public static List<Helpline> readFromFile() { // Made the method public and static
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            return (List<Helpline>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException("Failed to deserialize Helpline list.");
        }
    }
}
