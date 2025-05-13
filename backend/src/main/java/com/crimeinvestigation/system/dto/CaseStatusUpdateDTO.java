package com.crimeinvestigation.system.dto;

import com.crimeinvestigation.system.enums.CaseStatus;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CaseStatusUpdateDTO {
    private Long caseId;
    private CaseStatus newStatus;
}
