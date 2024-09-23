package com.demo.conductor.workflow.case_match.model;

import lombok.Data;

@Data
public class CaseRequest {
    private String caseId;
    private String caseType;
    private String caseStatus;
    private String caseDescription;
}
