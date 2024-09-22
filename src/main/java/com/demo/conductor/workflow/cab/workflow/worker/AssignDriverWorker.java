package com.demo.conductor.workflow.cab.workflow.worker;

import com.netflix.conductor.client.worker.Worker;
import com.netflix.conductor.common.metadata.tasks.Task;
import com.netflix.conductor.common.metadata.tasks.TaskResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Slf4j
@Component
public class AssignDriverWorker implements Worker {
    @Override
    public String getTaskDefName() {
        return "assign_driver";
    }

    @Override
    public TaskResult execute(Task task) {
        log.info("Assigned driver worker is triggered");
        TaskResult taskResult = new TaskResult(task);
        taskResult.setStatus(TaskResult.Status.COMPLETED);
        String bookingId = (String) task.getInputData().get("bookingId");
        taskResult.addOutputData("bookingId", bookingId);
        taskResult.addOutputData("driverId", UUID.randomUUID().toString());
        return taskResult;
    }
}
