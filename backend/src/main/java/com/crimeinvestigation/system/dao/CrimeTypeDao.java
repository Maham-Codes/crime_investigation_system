package com.crimeinvestigation.system.dao;

import com.crimeinvestigation.system.DatabaseConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CrimeTypeDao {
    public void getAllCrimeTypes() {
        String sql = "SELECT * FROM CrimeType";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            System.out.println("=== Crime Types in Database ===");

            while (rs.next()) {
                int id = rs.getInt("typeID");
                String name = rs.getString("crimeName");
                System.out.println("Type ID: " + id + ", Crime Name: " + name);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
