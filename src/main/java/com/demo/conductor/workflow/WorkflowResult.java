package com.demo.conductor.workflow;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class WorkflowResult {
    private String workflowId;
}
