package com.demo.conductor.workflow.case_match.workflow;

import com.demo.conductor.workflow.WorkflowResult;
import com.demo.conductor.workflow.case_match.model.CaseRequest;

public interface CaseMatchWorkflowService {
    WorkflowResult initWorkflow(CaseRequest caseRequest);
}
