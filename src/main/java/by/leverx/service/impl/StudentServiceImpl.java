package by.leverx.service.impl;

import by.leverx.model.Student;
import by.leverx.model.enums.Subject;
import by.leverx.service.StudentService;
import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StudentServiceImpl implements StudentService {

    public double avgBySubject(List<Student> students, Subject subject) {
        return students.stream()
                .mapToInt(s -> s.getRating().get(subject.getSubject()))
                .average().orElse(0);
    }

    @Override
    public String groupBySubject(List<Student> students) {
        StringBuilder info = new StringBuilder();

        Arrays.stream(Subject.values()).forEach(subject -> {
            info.append(subject.getSubject()).append(": ").append("(");
            Map<String, Integer> student = students.stream().collect(Collectors.toMap(
                    Student::getName, s -> s.getRating().get(subject.getSubject())
            ));

            String prefix = "";
            for (Map.Entry<String, Integer> entry : student.entrySet()) {
                info.append(prefix);
                prefix = ", ";
                info.append(entry.getKey()).append(": ").append(entry.getValue());
            }

            info.append(")\n");
        });

        return info.toString().trim();
    }
}
