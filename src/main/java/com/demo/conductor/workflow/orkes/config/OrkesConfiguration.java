package com.demo.conductor.workflow.orkes.config;

import com.demo.conductor.workflow.ConductorServerConfig;
import com.netflix.conductor.client.worker.Worker;
import io.orkes.conductor.client.*;
import io.orkes.conductor.client.automator.TaskRunnerConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class OrkesConfiguration {


    @Bean
    public OrkesClients orkesClients(ConductorServerConfig serverConfig) {
        ApiClient apiClient = new ApiClient(serverConfig.getServerUrl(), serverConfig.getClientKeyId(), serverConfig.getClientSecret());
        return new OrkesClients(apiClient);
    }

    @Bean
    public TaskClient taskClient(OrkesClients orkesClients) {
        return orkesClients.getTaskClient();
    }

    @Bean
    public WorkflowClient workflowClient(OrkesClients orkesClients) {
        return orkesClients.getWorkflowClient();
    }

    @Bean
    public TaskRunnerConfigurer taskRunnerConfigurer(List<Worker> workerList, TaskClient taskClient) {
        TaskRunnerConfigurer taskRunnerConfigurer = new TaskRunnerConfigurer.Builder(taskClient, workerList)
                .withThreadCount(Math.max(1, workerList.size()))
                .build();
        taskRunnerConfigurer.init();
        return taskRunnerConfigurer;
    }


    @Bean
    public MetadataClient metadataClient(OrkesClients orkesClients) {
        return orkesClients.getMetadataClient();
    }


}
