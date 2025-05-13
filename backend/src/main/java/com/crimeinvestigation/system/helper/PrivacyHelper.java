package com.crimeinvestigation.system.helper;

import com.crimeinvestigation.system.interfaces.SensitiveData;
import com.crimeinvestigation.system.interfaces.DataProcessor;
import com.crimeinvestigation.system.model.Criminal;
import com.crimeinvestigation.system.model.Investigator;
import com.crimeinvestigation.system.model.User;

public class PrivacyHelper {

    public static <T> T processIfSensitive(T obj, DataProcessor<T> processor) {
        if (obj instanceof SensitiveData) {
            return processor.process(obj);
        } else {
            return obj;
        }
    }

    public static DataProcessor<User> maskUserFields() {
        return user -> {
            if (user.getCnic() != null && user.getCnic().length() >= 4) {
                user.setCnic("****" + user.getCnic().substring(user.getCnic().length() - 4));
            }
            if (user.getContactNumber() != null && user.getContactNumber().length() >= 4) {
                user.setContactNumber("XXXX-XXXX");
            }
            if (user.getFirstName() != null) {
                user.setFirstName(user.getFirstName().charAt(0) + "***");
            }
            return user;
        };
    }

    public static DataProcessor<Criminal> maskCriminalFields() {
        return criminal -> {
            criminal.setFirstName(maskName(criminal.getFirstName()));
            criminal.setCnic(maskCnic(criminal.getCnic()));
            criminal.setContactNumber(maskContact(criminal.getContactNumber()));
            return criminal;
        };
    }

    public static DataProcessor<Investigator> maskInvestigatorFields() {
        return investigator -> {
            investigator.setFirstName(maskName(investigator.getFirstName()));
            investigator.setCnic(maskCnic(investigator.getCnic()));
            investigator.setContactNumber(maskContact(investigator.getContactNumber()));
            return investigator;
        };
    }

    private static String maskName(String name) {
        if (name != null && name.length() > 0) {
            return name.charAt(0) + "***";
        }
        return "";
    }

    private static String maskCnic(String cnic) {
        if (cnic != null && cnic.length() >= 4) {
            return "****" + cnic.substring(cnic.length() - 4);
        }
        return "****";
    }

    private static String maskContact(String contact) {
        if (contact != null && contact.length() >= 4) {
            return "XXXX-XXXX";
        }
        return "XXXX";
    }
}

