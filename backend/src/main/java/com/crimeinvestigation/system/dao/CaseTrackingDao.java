package com.crimeinvestigation.system.dao;

import com.crimeinvestigation.system.DatabaseConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CaseTrackingDao {
    public void getCasesWithAboveAverageUpdates() {
        //Show me all cases that have more updates than the average number of updates per case
        String sql = "SELECT " +
                "cc.caseID, " +
                "cc.caseType, " +
                "COUNT(ts.trackingID) AS totalUpdates " +
                "FROM crime_case cc " +
                "JOIN tracking_status ts ON cc.caseID = ts.caseID " +
                "GROUP BY cc.caseID, cc.caseType " +
                "HAVING COUNT(ts.trackingID) > (" +
                "   SELECT AVG(updateCount) FROM (" +
                "       SELECT COUNT(trackingID) AS updateCount FROM tracking_status GROUP BY caseID" +
                "   ) AS avgUpdates" +
                ")";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            System.out.println("=== Cases with Above Average Tracking Updates ===");

            while (rs.next()) {
                int caseId = rs.getInt("caseID");
                String caseType = rs.getString("caseType");
                int totalUpdates = rs.getInt("totalUpdates");

                System.out.println("Case ID: " + caseId + ", Case Type: " + caseType +
                        ", Total Updates: " + totalUpdates);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
