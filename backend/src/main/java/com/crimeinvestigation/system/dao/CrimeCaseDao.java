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
                SELECT cc.caseID, cc.caseType, cc.caseStatus
                FROM crime_case cc
                WHERE (
                    SELECT t.updateStatus
                    FROM tracking_status t
                    WHERE t.caseID = cc.caseID
                    ORDER BY t.trackingID DESC
                    LIMIT 1
                ) LIKE '%Closed%'
                """;

        return jdbcTemplate.queryForList(sql);
    }
}
