package com.assignment.wellness360.task_management_system.service;

import com.assignment.wellness360.task_management_system.entity.Task;

import org.springframework.data.domain.Pageable;
import java.util.List;

public interface TaskService
{
    Task createTask(Task request);

    List<Task> getAllTasks(Pageable pageable);

    Task getTaskById(Long id);

    Task updateTask(Long id, Task toUpdate);

    Task markTaskComplete(Long id);

    void deleteTaskById(Long id);
}
