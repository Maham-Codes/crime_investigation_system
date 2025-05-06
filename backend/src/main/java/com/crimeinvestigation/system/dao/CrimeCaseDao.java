package com.crimeinvestigation.system.dao;

import com.crimeinvestigation.system.DatabaseConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CrimeCaseDao {
    public void getClosedCases() {
        //correlated subquery
        //List cases where the latest tracking update contains the word 'Closed'.

        String sql = "SELECT " +
                "cc.caseID, " +
                "cc.caseType, " +
                "cc.caseStatus " +
                "FROM Crime_Case cc " +
                "WHERE (" +
                "    SELECT t.updateStatus " +
                "    FROM Tracking_Status t " +
                "    WHERE t.caseID = cc.caseID " +
                "    ORDER BY t.trackingID DESC " +
                "    LIMIT 1" +
                ") LIKE '%Closed%'";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            System.out.println("=== Closed Cases (Based on Latest Tracking Update) ===");

            while (rs.next()) {
                int caseId = rs.getInt("caseID");
                String caseType = rs.getString("caseType");
                String caseStatus = rs.getString("caseStatus");

                System.out.println("Case ID: " + caseId + ", Case Type: " + caseType +
                        ", Case Status: " + caseStatus);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
