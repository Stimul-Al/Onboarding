import by.leverx.model.Student;
import by.leverx.model.enums.Subject;
import by.leverx.service.StudentService;
import by.leverx.service.impl.StudentServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

public class StudentTest {

    private StudentService service;

    @BeforeEach
    void init() {
        service = new StudentServiceImpl();
    }

    @Test
    void avgSubject_happyPath() {
        //given
        List<Student> students = Util.getStudents();

        double avM = (10 + 7 + 8) / 3D;

        //when
        double averageMath = service.avgBySubject(students, Subject.MATH);

        //then
        Assertions.assertEquals(averageMath, avM);
    }

    @Test
    void groupStudentsBySubject_happyPath() {
        //given
        List<Student> students = Util.getStudents();
        String infoExpected = Util.infoStudents();

        //when
        String infoActual = service.groupBySubject(students);

        //then
        Assertions.assertEquals(infoExpected, infoActual);
    }
}
