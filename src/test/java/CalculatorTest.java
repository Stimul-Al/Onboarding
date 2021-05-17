import by.leverx.Calculator;
import by.leverx.dto.TaskDto;
import by.leverx.mapper.TaskMapper;
import by.leverx.mapper.TaskMapperImpl;
import by.leverx.model.Student;
import by.leverx.model.enums.Subject;
import by.leverx.model.Task;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

public class CalculatorTest {

    Calculator calculator;
    TaskMapper mapper;

    @BeforeEach
    void init() {
        calculator = new Calculator();
        mapper = new TaskMapperImpl();
    }

    @Test
    void avgSubject_happyPath() {
        //given
        List<Student> students = Util.getStudents();

        double avM = (10 + 7 + 8) / 3D;

        //when
        double averageMath = calculator.avgBySubject(students, Subject.MATH);

        //then
        Assertions.assertEquals(averageMath, avM);
    }

    @Test
    void findFirstTask_happyPath() {
        //given
        List<Task> tasks = Util.getTask();
        String strActual = "Read Version Control with Git book, Read Java 8 Lambdas book, Read Domain Driven Design book";

        //when
        String str = calculator.findFiveFirstTaskToReading(tasks);

        //then
        Assertions.assertEquals(str, strActual);
    }

    @Test
    void checkMapper() {
        //given
        Task task = Util.getTask().get(0);

        //when
        TaskDto dto = mapper.mapToDto(task);

        //then
        Assertions.assertEquals(task.getId(), dto.getId());
        Assertions.assertEquals(task.getTitle(), dto.getTitle());
        Assertions.assertEquals(task.getType(), dto.getType());
        Assertions.assertEquals(task.getTags(), dto.getTags());
    }
}
