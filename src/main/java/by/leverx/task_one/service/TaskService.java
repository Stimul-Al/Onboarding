package by.leverx.task_one.service;

import by.leverx.task_one.dto.TaskDto;
import by.leverx.task_one.model.Task;
import by.leverx.task_one.model.enums.TaskType;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

public interface TaskService {

    String findFiveFirstTaskToReading(List<Task> tasks);

    List<TaskDto> mapToDto(List<Task> tasks);

    Map<String, List<Task>> groupByTitle(List<Task> tasks);

    Map<String, List<Task>> groupById(List<Task> tasks);

    Map<LocalDate, List<Task>> groupByCreateAt(List<Task> tasks);

    Map<TaskType, List<Task>> groupByType(List<Task> tasks);

}
