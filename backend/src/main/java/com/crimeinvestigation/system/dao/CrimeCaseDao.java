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
        SELECT cc.case_id, cc.case_status
        FROM crime_case cc
        JOIN tracking_status t ON t.case_id = cc.case_id
        WHERE t.tracking_id = (
            SELECT MAX(ts.tracking_id)
            FROM tracking_status ts
            WHERE ts.case_id = cc.case_id
        )
        AND t.update_status LIKE '%closed%'
        """;


        return jdbcTemplate.queryForList(sql);
    }
}

