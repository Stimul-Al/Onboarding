package by.leverx.service;

import by.leverx.model.Student;
import by.leverx.model.enums.Subject;

import java.util.List;

public interface StudentService {

    double avgBySubject(List<Student> students, Subject subject);

    String groupBySubject(List<Student> students);
}
