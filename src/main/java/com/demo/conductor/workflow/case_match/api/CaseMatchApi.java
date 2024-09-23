package com.demo.conductor.workflow.case_match.api;

import com.demo.conductor.workflow.WorkflowResult;
import com.demo.conductor.workflow.case_match.model.CaseRequest;
import com.demo.conductor.workflow.case_match.workflow.CaseMatchWorkflowService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/case-match")
@RequiredArgsConstructor
public class CaseMatchApi {

    private final CaseMatchWorkflowService workflowService;

    @PostMapping
    public ResponseEntity<WorkflowResult> startCaseMatchWorkflow(@RequestBody CaseRequest caseRequest) {
        var workflowResult = workflowService.initWorkflow(caseRequest);
        return ResponseEntity.ok(workflowResult);
    }
}
