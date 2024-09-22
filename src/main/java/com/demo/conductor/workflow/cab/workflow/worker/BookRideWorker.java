package com.demo.conductor.workflow.cab.workflow.worker;

import com.netflix.conductor.client.worker.Worker;
import com.netflix.conductor.common.metadata.tasks.Task;
import com.netflix.conductor.common.metadata.tasks.TaskResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Slf4j
@Component
public class BookRideWorker implements Worker {

    @Override
    public String getTaskDefName() {
        return "book_ride";
    }

    @Override
    public TaskResult execute(Task task) {
        log.info("Book ride worker is triggered");
        TaskResult taskResult = new TaskResult(task);
        taskResult.addOutputData("bookingId", UUID.randomUUID().toString());
        taskResult.setStatus(TaskResult.Status.COMPLETED);
        return taskResult;
    }
}
