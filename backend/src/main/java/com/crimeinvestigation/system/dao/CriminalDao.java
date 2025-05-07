package com.crimeinvestigation.system.dao;

import com.crimeinvestigation.system.DatabaseConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CriminalDao {
    public void getActiveCriminalCases() {
        //subquery using 2 joins
        //gives criminalID,crimeType,case description, investigators first and last name for convicted criminals
        String sql = "SELECT " +
                "c.criminalID, " +
                "c.crimeType, " +
                "cc.description AS caseDescription, " +
                "u.first_name AS investigatorFirstName," +
                "u.last_name AS investigatorLastName, " +
                "c.currentStatus " +
                "FROM criminal c " +
                "JOIN crime_case cc ON c.caseID = cc.caseID " +
                "JOIN user u ON cc.userID = u.userID " +
                "WHERE c.currentStatus='Convicted'";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            System.out.println("=== Active Criminal Cases for convicted===");

            while (rs.next()) {
                int criminalId = rs.getInt("criminalID");
                String crimeType = rs.getString("crimeType");
                String caseDescription = rs.getString("caseDescription");
                String officerName = rs.getString("investigatorFirstName") + " " + rs.getString("investigatorLastName");
                String currentStatus = rs.getString("currentStatus");

                System.out.println("Criminal ID: " + criminalId + ", Crime Type: " + crimeType +
                        ", Case Description: " + caseDescription + ", Officer: " + officerName +
                        ", Status: " + currentStatus);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
