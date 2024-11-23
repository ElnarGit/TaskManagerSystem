package com.saparov.TaskManagerSystem.exception;

public class TaskNotFoundException extends NotFoundException {

    public TaskNotFoundException(Long id) {
        super("Задача с ID " + id + " не найдена", "TASK_NOT_FOUND");
    }
}