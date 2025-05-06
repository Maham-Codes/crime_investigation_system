package com.crimeinvestigation.system.dao;

import com.crimeinvestigation.system.DatabaseConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class HelplineDao {
    public void getHelplinesByRegionAndType(String region, String type) {
        String sql = "SELECT * FROM Helpline WHERE region_area = ? AND helplinetype = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            // Set query parameters
            stmt.setString(1, region);
            stmt.setString(2, type);

            try (ResultSet rs = stmt.executeQuery()) {
                System.out.println("=== Helplines for Region: " + region + ", Type: " + type + " ===");

                while (rs.next()) {
                    int id = rs.getInt("helplineID");
                    String regionArea = rs.getString("region_area");
                    String number = rs.getString("helplinenumber");
                    String helplineType = rs.getString("helplinetype");

                    System.out.println("ID: " + id + ", Region: " + regionArea + ", Number: " + number + ", Type: " + helplineType);
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}