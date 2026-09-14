package com.assignment.wellness360.task_management_system.controller;

import com.assignment.wellness360.task_management_system.dto.TaskDto;
import com.assignment.wellness360.task_management_system.entity.Task;
import com.assignment.wellness360.task_management_system.enums.TaskStatus;
import com.assignment.wellness360.task_management_system.mapper.TaskMapper;
import com.assignment.wellness360.task_management_system.service.TaskService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/tasks")
public class TaskController
{
    private final TaskService taskService;
    private final TaskMapper taskMapper;


    @PostMapping
    public ResponseEntity<TaskDto> createTask(@Valid @RequestBody TaskDto request)
    {
        // Transform request
        Task taskRequest = taskMapper.toEntity(request);
        taskRequest.setTaskStatus(TaskStatus.PENDING);

        Task savedTask = taskService.createTask(taskRequest);

        // Transform response
        TaskDto taskResponse = taskMapper.toDto(savedTask);

        return ResponseEntity.status(201).body(taskResponse);
    }


    @GetMapping
    public ResponseEntity<List<TaskDto>> getAllTasks(
            @RequestParam(defaultValue = "1", required = false) int pageNo,
            @RequestParam(defaultValue = "10", required = false) int pageSize)
    {
        List<TaskDto> tasks = taskService.getAllTasks(PageRequest.of(pageNo-1, pageSize))
                .stream()
                .map(task -> taskMapper.toDto(task))
                .toList();

        return ResponseEntity.ok(tasks);
    }


    @GetMapping("/{id}")
    public ResponseEntity<TaskDto> getTaskById(@PathVariable Long id)
    {
        Task task = taskService.getTaskById(id);

        TaskDto taskR = taskMapper.toDto(task);

        return ResponseEntity.ok(taskR);
    }


    @PutMapping("/{id}")
    public ResponseEntity<TaskDto> updateTask(@PathVariable Long id, @RequestBody TaskDto updateTaskRequest)
    {
        Task taskRequest = taskMapper.toEntity(updateTaskRequest);

        Task task = taskService.updateTask(id, taskRequest);

        TaskDto updatedTask = taskMapper.toDto(task);

        return ResponseEntity.ok(updatedTask);
    }


    @PatchMapping("/{id}/complete")
    public ResponseEntity<TaskDto> markTaskComplete(@PathVariable Long id)
    {
        Task task = taskService.markTaskComplete(id);
        TaskDto completedTask = taskMapper.toDto(task);

        return ResponseEntity.ok(completedTask);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTaskById(@PathVariable Long id)
    {
        taskService.deleteTaskById(id);

        return ResponseEntity.noContent().build();
    }
}
