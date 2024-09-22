package com.demo.conductor.workflow.cab.api;

import com.demo.conductor.workflow.WorkflowResult;
import com.demo.conductor.workflow.cab.dto.CabInput;
import com.demo.conductor.workflow.cab.workflow.CabWorkflowService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/cab")
public class CabBookingController {

    private final CabWorkflowService cabWorkflowService;

    @PostMapping
    public ResponseEntity<WorkflowResult> startCabWorkflow(@RequestBody CabInput cabInput) {
        WorkflowResult workflowResult = cabWorkflowService.startCabWorkflow(cabInput);
        return ResponseEntity.ok().body(workflowResult);
    }
}
