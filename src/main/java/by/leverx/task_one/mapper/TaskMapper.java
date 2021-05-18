package by.leverx.task_one.mapper;

import by.leverx.task_one.dto.TaskDto;
import by.leverx.task_one.model.Task;

public interface TaskMapper {

    TaskDto mapToDto(Task task);

}
