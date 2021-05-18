package by.leverx.task_one.service;

import by.leverx.task_one.model.Student;
import by.leverx.task_one.model.enums.Subject;

import java.util.List;

public interface StudentService {

    double avgBySubject(List<Student> students, Subject subject);

    String groupBySubject(List<Student> students);
}
