package com.assignment.wellness360.task_management_system.service.impl;

import com.assignment.wellness360.task_management_system.entity.Task;
import com.assignment.wellness360.task_management_system.enums.TaskStatus;
import com.assignment.wellness360.task_management_system.exception.ResourceNotFoundException;
import com.assignment.wellness360.task_management_system.repository.TaskRepository;
import com.assignment.wellness360.task_management_system.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import org.springframework.data.domain.Pageable;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TaskServiceImpl implements TaskService
{
    private final TaskRepository taskRepository;


    @Override
    public Task createTask(Task request)
    {
        return taskRepository.save(request);
    }


    @Override
    public List<Task> getAllTasks(Pageable pageable)
    {
        return taskRepository.findAll(pageable).getContent();
    }


    @Override
    public Task getTaskById(Long id)
    {
        return taskRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Task is not found with id: "+id));
    }


    @Override
    public Task updateTask(Long id, Task toUpdate)
    {
        Task task = taskRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Task is not found with id: "+id));

        task.setTitle(toUpdate.getTitle());
        task.setDescription(toUpdate.getDescription());
        task.setTaskStatus(toUpdate.getTaskStatus());
        task.setDueDate(toUpdate.getDueDate());

        return taskRepository.save(task);
    }


    @Override
    public Task markTaskComplete(Long id)
    {
        Task task = taskRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Task is not found with id: "+id));

        task.setTaskStatus(TaskStatus.COMPLETED);

        return taskRepository.save(task);
    }


    @Override
    public void deleteTaskById(Long id)
    {
        Task task = taskRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Task is not found with id: "+id));

        taskRepository.deleteById(task.getId());
    }
}
