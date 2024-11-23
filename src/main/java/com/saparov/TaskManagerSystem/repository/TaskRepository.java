package com.saparov.TaskManagerSystem.repository;

import com.saparov.TaskManagerSystem.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Long> {
}
