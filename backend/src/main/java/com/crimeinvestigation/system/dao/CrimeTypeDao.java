//package com.crimeinvestigation.system.dao;
//
//import com.crimeinvestigation.system.DatabaseConnection;
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//
//public class CrimeTypeDao {
//    public void getAllCrimeTypes() {
//        String sql = "SELECT * FROM crimetype";
//
//        try (Connection conn = DatabaseConnection.getConnection();
//             PreparedStatement stmt = conn.prepareStatement(sql);
//             ResultSet rs = stmt.executeQuery()) {
//
//            System.out.println("=== Crime Types in Database ===");
//
//            while (rs.next()) {
//                int id = rs.getInt("typeID");
//                String crimeName = rs.getString("crimeName");
//                System.out.println("Type ID: " + id + ", Crime Name: " + crimeName);
//            }
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
//}

package com.crimeinvestigation.system.dao;

import com.crimeinvestigation.system.model.CrimeType;
import com.crimeinvestigation.system.DatabaseConnection;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;



@Repository
public class CrimeTypeDao {

    public List<CrimeType> getAllCrimeTypes() {
        List<CrimeType> crimeTypes = new ArrayList<>();
        String sql = "SELECT * FROM crimetype";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                CrimeType crimeType = new CrimeType();
                crimeType.setTypeID(rs.getInt("typeID"));
                crimeType.setCrimeName(rs.getString("crimeName"));
                System.out.println("DEBUG — ID: " + crimeType.getTypeID() + ", Name: " + crimeType.getCrimeName());
                crimeTypes.add(crimeType);
            }

        } catch (SQLException e) {
            System.err.println("Error retrieving crime types:");
            e.printStackTrace();
        }

        return crimeTypes;
    }
}

