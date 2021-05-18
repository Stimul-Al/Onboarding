package by.leverx.task_one.service.impl;

import by.leverx.task_one.dto.TaskDto;
import by.leverx.task_one.mapper.TaskMapper;
import by.leverx.task_one.mapper.TaskMapperImpl;
import by.leverx.task_one.model.Task;
import by.leverx.task_one.model.enums.TaskType;
import by.leverx.task_one.service.TaskService;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

import static by.leverx.task_one.model.enums.TaskType.READING;
import static java.util.stream.Collectors.*;

@RequiredArgsConstructor
public class TaskServiceImpl implements TaskService {

    private final TaskMapper mapper = new TaskMapperImpl();
    private final static Integer SIZE = 5;
    private final static String DELIMITER = ", ";

    @Override
    public String findFiveFirstTaskToReading(List<Task> tasks) {
        return tasks.stream()
                .filter(task -> READING.equals(task.getType()))
                .sorted(Comparator.comparing(Task::getCreatedOn))
                .limit(SIZE)
                .map(Task::getTitle)
                .collect(joining(DELIMITER));
    }

    @Override
    public List<TaskDto> mapToDto(List<Task> tasks) {
        return tasks.stream()
                .map(mapper::mapToDto)
                .collect(toList());
    }

    @Override
    public Map<String, List<Task>> groupByTitle(List<Task> tasks) {
        return tasks.stream().collect(
                groupingBy(Task::getTitle));
    }

    @Override
    public Map<String, List<Task>> groupById(List<Task> tasks) {
        return tasks.stream().collect(
                groupingBy(Task::getId));
    }

    @Override
    public Map<LocalDate, List<Task>> groupByCreateAt(List<Task> tasks) {
        return tasks.stream().collect(
                groupingBy(Task::getCreatedOn));
    }

    @Override
    public Map<TaskType, List<Task>> groupByType(List<Task> tasks) {
        return tasks.stream().collect(
                groupingBy(Task::getType));
    }
}
