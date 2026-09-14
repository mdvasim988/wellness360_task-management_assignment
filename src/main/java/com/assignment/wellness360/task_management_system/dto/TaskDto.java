package com.assignment.wellness360.task_management_system.dto;

import com.assignment.wellness360.task_management_system.enums.TaskStatus;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

public record TaskDto(
        Long id,

        @NotBlank(message = "Task title cannot be blank")
        @Size(min = 1, max = 100, message = "Title must be between 1 and 100 characters")
        String title,

        @Size(max = 500, message = "Description cannot exceed 500 characters")
        String description,

        @FutureOrPresent(message = "Due date must be today or in the future")
        LocalDate dueDate,

        TaskStatus taskStatus
) {
}
