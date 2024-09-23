package com.demo.conductor.workflow.cab.workflow.worker;

import com.netflix.conductor.client.worker.Worker;
import com.netflix.conductor.common.metadata.tasks.Task;
import com.netflix.conductor.common.metadata.tasks.TaskResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class NotifyDriverWorker implements Worker {

    @Override
    public String getTaskDefName() {
        return "notify_driver";
    }

    @Override
    public TaskResult execute(Task task) {
        TaskResult taskResult = new TaskResult(task);
        log.info("Notify driver worker has been init");
        taskResult.setStatus(TaskResult.Status.COMPLETED);
        return taskResult;
    }
}
