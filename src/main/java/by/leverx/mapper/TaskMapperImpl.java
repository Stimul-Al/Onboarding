package by.leverx.mapper;

import by.leverx.dto.TaskDto;
import by.leverx.model.Task;

public class TaskMapperImpl implements TaskMapper {

    @Override
    public TaskDto mapToDto(Task task) {
        return TaskDto.builder()
                .id(task.getId())
                .title(task.getTitle())
                .type(task.getType())
                .createdOn(task.getCreatedOn())
                .tags(task.getTags())
                .build();
    }
}
