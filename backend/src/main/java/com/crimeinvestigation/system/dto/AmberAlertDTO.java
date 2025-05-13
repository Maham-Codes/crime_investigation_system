package com.crimeinvestigation.system.dto;

import com.crimeinvestigation.system.enums.CaseStatus;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
public class AmberAlertDTO {
    private Long caseId;
    private String crimeType;
    private String location;
    private String description;
    private String reportedByName;
    private int age;
    private LocalDateTime dateTime;
    private CaseStatus caseStatus;
}

