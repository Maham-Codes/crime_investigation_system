package com.crimeinvestigation.system.dao;

import com.crimeinvestigation.system.DatabaseConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LowRatedCriminalsDao {
    public void getLowRatedInactiveCriminals() {

        //nested Subquery
        //Find criminals who are involved in cases with poor feedback (rating 2 or below), and those cases have not been updated in tracking for over 30 days.

        String sql = "SELECT c.criminalID, c.nationality, c.currentStatus, cc.caseID " +
                "FROM Criminal c " +
                "JOIN Crime_Case cc ON c.caseID = cc.caseID " +
                "WHERE cc.caseID IN ( " +
                "    SELECT f.caseID " +
                "    FROM Feedback f " +
                "    WHERE f.rating <= 2 " +
                "    AND f.caseID IN ( " +
                "        SELECT t.caseID " +
                "        FROM Tracking_Status t " +
                "        GROUP BY t.caseID " +
                "        HAVING MAX(t.updateStatus) < NOW() - INTERVAL 30 DAY " +
                "    ) " +
                ")";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            System.out.println("=== Low-Rated & Inactive Criminal Cases ===");

            while (rs.next()) {
                int criminalId = rs.getInt("criminalID");
                String nationality = rs.getString("nationality");
                String currentStatus = rs.getString("currentStatus");
                int caseId = rs.getInt("caseID");

                System.out.println("Criminal ID: " + criminalId +
                        ", Nationality: " + nationality +
                        ", Status: " + currentStatus +
                        ", Case ID: " + caseId);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
