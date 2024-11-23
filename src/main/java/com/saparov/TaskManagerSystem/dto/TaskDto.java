package com.saparov.TaskManagerSystem.dto;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.saparov.TaskManagerSystem.enums.TaskPriority;
import com.saparov.TaskManagerSystem.enums.TaskStatus;
import lombok.Data;
import java.time.LocalDateTime;

@Data
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class TaskDto {
    private Long id;
    private String title;
    private String description;
    private TaskStatus taskStatus;
    private TaskPriority priority;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private Long authorId;
    private Long assigneeId;
}
