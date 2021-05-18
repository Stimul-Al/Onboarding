import by.leverx.task_one.model.Student;
import by.leverx.task_one.model.enums.Subject;
import by.leverx.task_one.service.StudentService;
import by.leverx.task_one.service.impl.StudentServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import util.Util;

import java.util.List;

import static util.Util.getStudents;

public class StudentServiceTest {

    private StudentService service;

    @BeforeEach
    void init() {
        service = new StudentServiceImpl();
    }

    @Test
    void avgSubject_happyPath() {
        //given
        List<Student> students = getStudents();

        double avM = (10 + 7 + 8) / 3D;

        //when
        double averageMath = service.avgBySubject(students, Subject.MATH);

        //then
        Assertions.assertEquals(averageMath, avM);
    }

    @Test
    void groupStudentsBySubject_happyPath() {
        //given
        List<Student> students = getStudents();
        String infoExpected = Util.infoStudents();

        //when
        String infoActual = service.groupBySubject(students);

        //then
        Assertions.assertEquals(infoExpected, infoActual);
    }
}
