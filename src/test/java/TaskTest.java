import by.leverx.model.Task;
import by.leverx.model.enums.TaskType;
import by.leverx.service.TaskService;
import by.leverx.service.impl.TaskServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

public class TaskTest {

    private TaskService service;

    @BeforeEach
    void init() {
        service = new TaskServiceImpl();
    }

    @Test
    void findFirstTask_happyPath() {
        //given
        List<Task> tasks = Util.getTask();
        String strActual = "Read Version Control with Git book, Read Java 8 Lambdas book, Read Domain Driven Design book";

        //when
        String str = service.findFiveFirstTaskToReading(tasks);

        //then
        Assertions.assertEquals(str, strActual);
    }

    @Test
    void testGroupById_happyPath() {
        //
        List<Task> tasks = Util.getTask();
        String expectedStr = Util.groupById();

        //when
        Map<String, List<Task>> groupById = service.groupById(tasks);

        //then
        Assertions.assertEquals(expectedStr, groupById.toString());
    }

    @Test
    void testGroupByType_happyPath() {
        //
        List<Task> tasks = Util.getTask();
        String expectedStr = Util.groupByType();

        //when
        Map<TaskType, List<Task>> groupById = service.groupByType(tasks);

        //then
        Assertions.assertEquals(expectedStr, groupById.toString());
    }

    @Test
    void testGroupByTitle_happyPath() {
        //
        List<Task> tasks = Util.getTask();
        String expectedStr = Util.groupByTitle();

        //when
        Map<String, List<Task>> groupById = service.groupByTitle(tasks);

        //then
        Assertions.assertEquals(expectedStr, groupById.toString());
    }

    @Test
    void testGroupDate_happyPath() {
        //
        List<Task> tasks = Util.getTask();
        String expectedStr = Util.groupByDate();

        //when
        Map<LocalDate, List<Task>> groupById = service.groupByCreateAt(tasks);

        //then
        Assertions.assertEquals(expectedStr, groupById.toString());
    }

}
