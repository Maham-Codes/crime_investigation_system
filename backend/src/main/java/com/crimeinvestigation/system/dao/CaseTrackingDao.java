package com.crimeinvestigation.system.dao;

import com.crimeinvestigation.system.DatabaseConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CaseTrackingDao {
    public void getCasesWithAboveAverageUpdates() {
        // Show me all cases that have more updates than the average number of updates per case
        String sql = "SELECT cc.case_id, cc.case_status, COUNT(ts.tracking_id) AS totalUpdates " +
                "FROM crime_case cc " +
                "JOIN tracking_status ts ON cc.case_id = ts.case_id " +
                "GROUP BY cc.case_id, cc.case_status " +
                "HAVING COUNT(ts.tracking_id) > ( " +
                "  SELECT AVG(updateCount) FROM ( " +
                "    SELECT COUNT(tracking_id) AS updateCount FROM tracking_status GROUP BY case_id " +
                "  ) AS avgUpdates " +
                ")";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            System.out.println("=== Cases with Above Average Tracking Updates ===");

            while (rs.next()) {
                int caseId = rs.getInt("caseID");
                String caseStatus = rs.getString("caseStatus"); // Fixed from caseType ➜ caseStatus
                int totalUpdates = rs.getInt("totalUpdates");

                System.out.println("Case ID: " + caseId + ", Case Status: " + caseStatus +
                        ", Total Updates: " + totalUpdates);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
