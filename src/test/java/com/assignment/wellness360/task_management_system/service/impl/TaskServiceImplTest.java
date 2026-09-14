package com.assignment.wellness360.task_management_system.service.impl;

import com.assignment.wellness360.task_management_system.entity.Task;
import com.assignment.wellness360.task_management_system.enums.TaskStatus;
import com.assignment.wellness360.task_management_system.repository.TaskRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class TaskServiceImplTest
{
    @Mock
    private TaskRepository taskRepository;

    @InjectMocks
    private TaskServiceImpl taskService;

    private Task mockTaskInput;

    private Task savedMockTask;

    @BeforeEach
    void setUp()
    {
        mockTaskInput = Task.builder()
                .title("test-task")
                .description("this is a test task")
                .dueDate(LocalDate.now().plusDays(2)).build();

        savedMockTask = Task.builder()
                .id(1L)
                .title("test-task")
                .description("this is a test task")
                .dueDate(LocalDate.now().plusDays(2))
                .taskStatus(TaskStatus.PENDING)
                .build();
    }

    @Test
    void testCreateTask_shouldReturnSavedTask()
    {
        when(taskRepository.save(any(Task.class))).thenReturn(savedMockTask);

        Task resultTask = taskService.createTask(mockTaskInput);

        Assertions.assertThat(resultTask).isNotNull();
        Assertions.assertThat(resultTask.getTitle()).isEqualTo(mockTaskInput.getTitle());

        verify(taskRepository).save(any(Task.class));
    }
}