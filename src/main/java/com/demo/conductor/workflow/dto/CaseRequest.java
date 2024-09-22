package com.demo.conductor.workflow.dto;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.netflix.conductor.common.metadata.workflow.WorkflowDef;
import io.orkes.conductor.client.MetadataClient;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;

@Component
@RequiredArgsConstructor
public class CaseRequest {

    @Value("classpath:workflow/classify_workflow.json")
    private Resource resource;

    private final ObjectMapper objectMapper;
    private final MetadataClient metadataClient;

    @PostConstruct
    void loadConfiguration() throws IOException {
        WorkflowDef workflowDef = objectMapper.readValue(this.resource.getFile(), WorkflowDef.class);
        metadataClient.updateWorkflowDefs(List.of(workflowDef));
    }
}
