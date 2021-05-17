package by.leverx.service.impl;

import by.leverx.model.Task;
import by.leverx.model.enums.TaskType;
import by.leverx.service.TaskService;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class TaskServiceImpl implements TaskService {

    public String findFiveFirstTaskToReading(List<Task> tasks) {
        return tasks.stream()
                .filter(task -> task.getType().equals(TaskType.READING))
                .sorted(Comparator.comparing(Task::getCreatedOn))
                .limit(5)
                .map(Task::getTitle)
                .collect(Collectors.joining(", "));
    }

    @Override
    public Map<String, List<Task>> groupByTitle(List<Task> tasks) {
        return tasks.stream().collect(
                Collectors.groupingBy(Task::getTitle));
    }

    @Override
    public Map<String, List<Task>> groupById(List<Task> tasks) {
        return tasks.stream().collect(
                Collectors.groupingBy(Task::getId));
    }

    @Override
    public Map<LocalDate, List<Task>> groupByCreateAt(List<Task> tasks) {
        return tasks.stream().collect(
                Collectors.groupingBy(Task::getCreatedOn));
    }

    @Override
    public Map<TaskType, List<Task>> groupByType(List<Task> tasks) {
        return tasks.stream().collect(
                Collectors.groupingBy(Task::getType));
    }
}
