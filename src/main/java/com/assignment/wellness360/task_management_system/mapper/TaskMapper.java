package com.assignment.wellness360.task_management_system.mapper;

import com.assignment.wellness360.task_management_system.dto.TaskDto;
import com.assignment.wellness360.task_management_system.entity.Task;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TaskMapper
{
    TaskDto toDto(Task task);
    Task toEntity(TaskDto taskDto);
}
