package com.demo.conductor.workflow.cab.workflow;

import com.demo.conductor.workflow.Payload;
import com.demo.conductor.workflow.WorkflowResult;
import com.demo.conductor.workflow.WorkflowStarter;
import com.demo.conductor.workflow.cab.dto.CabInput;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
@RequiredArgsConstructor
public class CabWorkflowService {

    private final WorkflowStarter workflowStarter;

    public WorkflowResult startCabWorkflow(CabInput cabInput) {
        Payload payload = new Payload();
        payload.setWorkflowName("cab_service_saga_booking_wf");
        payload.setInputPayload(Map.of("bookingRequest", cabInput));
        String workflowId = workflowStarter.startWorkflow(payload);
        return WorkflowResult.builder().workflowId(workflowId)
                .build();
    }

}
