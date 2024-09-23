package com.demo.conductor.workflow.starter;

import com.demo.conductor.workflow.Payload;
import com.netflix.conductor.common.metadata.workflow.StartWorkflowRequest;
import io.orkes.conductor.client.WorkflowClient;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class WorkflowStarterImpl implements WorkflowStarter {

    private final WorkflowClient workflowClient;

    public String processStater(Payload payload) {
        var startWorkflowRequest = new StartWorkflowRequest();
        startWorkflowRequest.setName(payload.getWorkflowName());
        startWorkflowRequest.setInput(payload.getInputPayload());
        return workflowClient.startWorkflow(startWorkflowRequest);
    }

}
