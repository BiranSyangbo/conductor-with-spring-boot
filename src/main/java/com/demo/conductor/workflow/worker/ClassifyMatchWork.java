package com.demo.conductor.workflow.worker;

import com.netflix.conductor.client.worker.Worker;
import com.netflix.conductor.common.metadata.tasks.Task;
import com.netflix.conductor.common.metadata.tasks.TaskResult;
import org.springframework.stereotype.Component;

import java.time.Instant;

@Component
public class ClassifyMatchWork implements Worker {

    @Override
    public String getTaskDefName() {
        return "classify_match_task";
    }

    @Override
    public TaskResult execute(Task task) {
        System.out.println(task);
        TaskResult result = new TaskResult(task);
        result.setStatus(TaskResult.Status.COMPLETED);
        String currentTimeOnServer = Instant.now().toString();
        result.log("This is a test log at time: " + currentTimeOnServer);
        result.addOutputData("currentTimeOnServer", currentTimeOnServer);
        result.addOutputData("message", "Hello World!");
        return result;
    }
}
