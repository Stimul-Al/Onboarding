package by.leverx.task_one.service.impl;

import by.leverx.task_one.model.Student;
import by.leverx.task_one.model.enums.Subject;
import by.leverx.task_one.service.StudentService;

import java.util.*;

import static java.util.stream.Collectors.joining;

public class StudentServiceImpl implements StudentService {

    @Override
    public double avgBySubject(List<Student> students, Subject subject) {
        return students.stream()
                .mapToInt(s -> s.getRating().get(subject.getSubject()))
                .average().orElse(0);
    }

    @Override
    public String groupBySubject(List<Student> students) {
        return students.stream()
                .map(Student::getRating)
                .map(Map::keySet)
                .reduce(new HashSet<>(), (outputSet, subjectSet) -> {
                    outputSet.addAll(subjectSet);
                    return outputSet;
                }).stream()
                .map(subject -> subject + ": " + parseStudent(students, subject))
                .collect(joining("\n"));
    }

    private String parseStudent(List<Student> students, String subject) {
        return students.stream()
                .map(student -> student.getName() + ": " + student.getRating().get(subject))
                .collect(joining(", ", "(", ")"));
    }
}
