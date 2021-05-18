package by.leverx.task_one.model;

import by.leverx.task_one.model.enums.TaskType;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Data
@RequiredArgsConstructor
public class Task {

    private final String id;
    private final String title;
    private final TaskType type;
    private final LocalDate createdOn;
    private boolean done = false;
    private Set<String> tags = new HashSet<>();
    private LocalDate dueTo;

    public Task(String title, TaskType type, LocalDate createdOn) {
        this.id = type.toString();
        this.title = title;
        this.type = type;
        this.createdOn = createdOn;
    }

    public Task addTag(String tag) {
        tags.add(tag);
        return this;
    }


}
