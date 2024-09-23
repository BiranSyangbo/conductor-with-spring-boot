package com.demo.conductor.workflow.case_match.workflow;

import com.demo.conductor.workflow.Payload;
import com.demo.conductor.workflow.WorkflowResult;
import com.demo.conductor.workflow.starter.WorkflowStarter;
import com.demo.conductor.workflow.case_match.model.CaseRequest;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Map;

@Slf4j
@Service
@RequiredArgsConstructor
public class CaseMatchWorkflowServiceImpl implements CaseMatchWorkflowService {

    public static final String CASE_APPROVAL_WORKFLOW = "CaseApprovalWorkflow";
    private final WorkflowStarter workflowStarter;
    private final ObjectMapper objectMapper;

    @Override
    public WorkflowResult initWorkflow(CaseRequest caseRequest) {
        Payload payload = buildPayload(caseRequest);
        String workflowId = workflowStarter.processStater(payload);
        return WorkflowResult.builder().workflowId(workflowId).build();
    }

    private Payload buildPayload(CaseRequest caseRequest) {
        return Payload.builder()
                .workflowName(CASE_APPROVAL_WORKFLOW)
                .inputPayload(buildInputPayload(caseRequest))
                .build();
    }

    private Map<String, Object> buildInputPayload(CaseRequest caseRequest) {
        return objectMapper.convertValue(caseRequest, new TypeReference<>() {
        });
    }
}
