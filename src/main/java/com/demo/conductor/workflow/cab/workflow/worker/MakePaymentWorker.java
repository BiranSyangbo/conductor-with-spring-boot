package com.demo.conductor.workflow.cab.workflow.worker;

import com.netflix.conductor.client.worker.Worker;
import com.netflix.conductor.common.metadata.tasks.Task;
import com.netflix.conductor.common.metadata.tasks.TaskResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class MakePaymentWorker implements Worker {
    @Override
    public String getTaskDefName() {
        return "make_payment";
    }

    @Override
    public TaskResult execute(Task task) {
        log.info("make payment worker is triggered");
        TaskResult taskResult = new TaskResult(task);
        taskResult.setStatus(TaskResult.Status.COMPLETED);
        return taskResult;
    }
}
