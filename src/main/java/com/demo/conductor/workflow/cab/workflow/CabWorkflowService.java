package com.demo.conductor.workflow.cab.workflow;

import com.demo.conductor.workflow.Payload;
import com.demo.conductor.workflow.WorkflowResult;
import com.demo.conductor.workflow.starter.WorkflowStarter;
import com.demo.conductor.workflow.cab.dto.CabInput;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
@RequiredArgsConstructor
public class CabWorkflowService {

    public static final String CAB_SERVICE_SAGA_BOOKING_WF = "cab_service_saga_booking_wf";
    public static final String BOOKING_REQUEST = "bookingRequest";
    private final WorkflowStarter workflowStarter;

    public WorkflowResult startCabWorkflow(CabInput cabInput) {
        Payload payload = Payload.builder().workflowName(CAB_SERVICE_SAGA_BOOKING_WF)
                .inputPayload(Map.of(BOOKING_REQUEST, cabInput))
                .build();
        String workflowId = workflowStarter.processStater(payload);
        return WorkflowResult
                .builder()
                .workflowId(workflowId)
                .build();
    }

}
