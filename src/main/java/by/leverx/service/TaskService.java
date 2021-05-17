package by.leverx.service;

import by.leverx.model.Task;
import by.leverx.model.enums.TaskType;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

public interface TaskService {

    String findFiveFirstTaskToReading(List<Task> tasks);

    Map<String, List<Task>> groupByTitle(List<Task> tasks);

    Map<String, List<Task>> groupById(List<Task> tasks);

    Map<LocalDate, List<Task>> groupByCreateAt(List<Task> tasks);

    Map<TaskType, List<Task>> groupByType(List<Task> tasks);

}
