package by.leverx.mapper;

import by.leverx.dto.TaskDto;
import by.leverx.model.Task;

public interface TaskMapper {

    TaskDto mapToDto(Task task);

}
