package com.demo.conductor.workflow;

import lombok.Builder;
import lombok.Data;

import java.util.Map;

@Data
@Builder
public class Payload {
    private String workflowName;
    private Map<String, Object> inputPayload;
}
