package com.demo.conductor.workflow;

import lombok.Data;

import java.util.Map;

@Data
public class Payload {
    private String workflowName;
    private Map<String, Object> inputPayload;
}
