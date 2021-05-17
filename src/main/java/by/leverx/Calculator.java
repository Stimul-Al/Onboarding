package by.leverx;

import by.leverx.model.Student;
import by.leverx.model.enums.Subject;
import by.leverx.model.Task;
import by.leverx.model.enums.TaskType;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Calculator {

    public double avgBySubject(List<Student> students, Subject subject) {
        return students.stream()
                .mapToInt(s -> s.getRating().get(subject.getSubject()))
                .average().orElse(0);
    }

    public String findFiveFirstTaskToReading(List<Task> tasks) {
        return tasks.stream()
                .filter(task -> task.getType().equals(TaskType.READING))
                .sorted(Comparator.comparing(Task::getCreatedOn))
                .limit(5)
                .map(Task::getTitle)
                .collect(Collectors.joining(", "));
    }
}
