package com.saparov.TaskManagerSystem.mapper;

import com.saparov.TaskManagerSystem.dto.TaskDto;
import com.saparov.TaskManagerSystem.model.Task;
import org.springframework.stereotype.Component;

@Component
public class TaskMapper {

    public TaskDto toDto(Task task) {
        if (task == null) {
            return null;
        }

        TaskDto taskDto = new TaskDto();
        taskDto.setId(task.getId());
        taskDto.setTitle(task.getTitle());
        taskDto.setDescription(task.getDescription());
        taskDto.setTaskStatus(task.getTaskStatus());
        taskDto.setPriority(task.getPriority());
        taskDto.setCreatedAt(task.getCreatedAt());
        taskDto.setUpdatedAt(task.getUpdatedAt());
        taskDto.setAuthorId(task.getAuthor() != null ? task.getAuthor().getId() : null);
        taskDto.setAssigneeId(task.getAssignee() != null ? task.getAssignee().getId() : null);

        return taskDto;
    }


    public Task toEntity(TaskDto taskDto) {
        if (taskDto == null) {
            return null;
        }

        Task task = new Task();
        task.setId(taskDto.getId());
        task.setTitle(taskDto.getTitle());
        task.setDescription(taskDto.getDescription());
        task.setTaskStatus(taskDto.getTaskStatus());
        task.setPriority(taskDto.getPriority());
        task.setCreatedAt(taskDto.getCreatedAt());
        task.setUpdatedAt(taskDto.getUpdatedAt());

        return task;
    }
}
