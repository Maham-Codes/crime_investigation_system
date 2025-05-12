package com.crimeinvestigation.system.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class CrimeCaseDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Map<String, Object>> getClosedCases() {
        String sql = """
        SELECT cc.caseID, cc.case_name, cc.case_status
        FROM crime_case cc
        JOIN tracking_status t ON t.caseID = cc.caseID
        WHERE t.trackingID = (
            SELECT MAX(ts.trackingID)
            FROM tracking_status ts
            WHERE ts.caseID = cc.caseID
        )
        AND t.updateStatus LIKE '%Closed%'
        """;


        return jdbcTemplate.queryForList(sql);
    }
}
