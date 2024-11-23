package com.saparov.TaskManagerSystem.service.impl;

import com.saparov.TaskManagerSystem.exception.TaskNotFoundException;
import com.saparov.TaskManagerSystem.model.Task;
import com.saparov.TaskManagerSystem.repository.TaskRepository;
import com.saparov.TaskManagerSystem.service.TaskService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
@Slf4j
public class TaskServiceImpl implements TaskService {
    private final TaskRepository taskRepository;

    @Override
    public Task getById(Long id) {
        return taskRepository.findById(id)
                .orElseThrow(() -> new TaskNotFoundException(id));
    }


    @Override
    public List<Task> getAll() {
        return taskRepository.findAll();
    }

    @Override
    @Transactional
    public Task save(Task task) {
        return taskRepository.save(task);
    }

    @Override
    @Transactional
    public Task update(Task task) {
        Task existingTask = taskRepository.findById(task.getId())
                .orElseThrow(() -> new TaskNotFoundException(task.getId()));

        existingTask.setTitle(task.getTitle());
        existingTask.setDescription(task.getDescription());
        existingTask.setTaskStatus(task.getTaskStatus());
        existingTask.setPriority(task.getPriority());
        existingTask.setUpdatedAt(LocalDateTime.now());
        existingTask.setAssignee(task.getAssignee());

        return taskRepository.save(existingTask);
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        if (!taskRepository.existsById(id)) {
            throw new TaskNotFoundException(id);
        }
        taskRepository.deleteById(id);
    }
}
