package com.demo.conductor.workflow.case_match.worker;

import com.netflix.conductor.client.worker.Worker;
import com.netflix.conductor.common.metadata.tasks.Task;
import com.netflix.conductor.common.metadata.tasks.TaskResult;
import org.springframework.stereotype.Component;

@Component
public class CaseMetadataWorker implements Worker {
    @Override
    public String getTaskDefName() {
        return "set_case_metadata_state_in_wf";
    }

    @Override
    public TaskResult execute(Task task) {
        TaskResult taskResult = new TaskResult(task);
        taskResult.setStatus(TaskResult.Status.COMPLETED);
        return taskResult;
    }
}
