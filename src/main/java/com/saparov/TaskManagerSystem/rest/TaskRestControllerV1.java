package com.saparov.TaskManagerSystem.rest;

import com.saparov.TaskManagerSystem.dto.TaskDto;
import com.saparov.TaskManagerSystem.mapper.TaskMapper;
import com.saparov.TaskManagerSystem.model.Task;
import com.saparov.TaskManagerSystem.service.TaskService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/tasks")
public class TaskRestControllerV1 {
    private final TaskService taskService;
    private final TaskMapper taskMapper;

    @GetMapping("/{id}")
    public ResponseEntity<TaskDto> getTaskById(@PathVariable("id") Long id) {
        Task task = taskService.getById(id);
        TaskDto taskDto = taskMapper.toDto(task);
        return ResponseEntity.ok(taskDto);
    }


    @GetMapping
    public ResponseEntity<List<TaskDto>> getAllTasks(){
        List<TaskDto> taskDtos =  taskService
                .getAll().stream()
                .map(taskMapper::toDto)
                .toList();

        return ResponseEntity.ok(taskDtos);
    }

    @PostMapping
    public ResponseEntity<TaskDto> createTask(@RequestBody @Valid TaskDto taskDto) {
        Task task = taskMapper.toEntity(taskDto);

        Task savedTask =  taskService.save(task);
        return ResponseEntity.status(201).body(taskMapper.toDto(savedTask));
    }

    @PutMapping("{id}")
    public ResponseEntity<TaskDto> updateTask(@PathVariable("id") Long id, @RequestBody @Valid TaskDto taskDto){
        taskDto.setId(id);
        Task task = taskMapper.toEntity(taskDto);

        Task updatedTask = taskService.update(task);
        return ResponseEntity.ok(taskMapper.toDto(updatedTask));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTask(@PathVariable("id") Long id) {
        taskService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
