package com.demo.conductor.workflow;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.netflix.conductor.common.metadata.workflow.StartWorkflowRequest;
import io.orkes.conductor.client.WorkflowClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class WorkflowStarter {

    private final WorkflowClient workflowClient;

    public String startWorkflow(Payload payload) {
        var startWorkflowRequest = new StartWorkflowRequest();
        startWorkflowRequest.setName(payload.getWorkflowName());
        startWorkflowRequest.setInput(payload.getInputPayload());
        return workflowClient.startWorkflow(startWorkflowRequest);
    }

}
