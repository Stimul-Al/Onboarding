import by.leverx.model.Student;
import by.leverx.model.enums.Subject;
import by.leverx.model.Task;
import by.leverx.model.enums.TaskType;

import java.time.LocalDate;
import java.time.Month;
import java.util.Arrays;
import java.util.List;

public class Util {

    public static List<Student> getStudents() {
        Student student1 = new Student("Alex");
        student1.rate(Subject.MATH.getSubject(), 10);
        student1.rate(Subject.PHYSIC.getSubject(), 9);
        student1.rate(Subject.ENGLISH.getSubject(), 8);

        Student student2 = new Student("David");
        student2.rate(Subject.MATH.getSubject(), 7);
        student2.rate(Subject.PHYSIC.getSubject(), 6);
        student2.rate(Subject.ENGLISH.getSubject(), 6);

        Student student3 = new Student("Nik");
        student3.rate(Subject.MATH.getSubject(), 8);
        student3.rate(Subject.PHYSIC.getSubject(), 8);
        student3.rate(Subject.ENGLISH.getSubject(), 8);

        return Arrays.asList(student1, student2, student3);
    }

    public static List<Task> getTask() {
        Task task1 = new Task("Read Version Control with Git book", TaskType.READING, LocalDate.of(2015, Month.JULY, 1)).addTag("git").addTag("reading").addTag("books");

        Task task2 = new Task("Read Java 8 Lambdas book", TaskType.READING, LocalDate.of(2015, Month.JULY, 2)).addTag("java8").addTag("reading").addTag("books");

        Task task3 = new Task("Write a mobile application to store my tasks", TaskType.CODING, LocalDate.of(2015, Month.JULY, 3)).addTag("coding").addTag("mobile");

        Task task4 = new Task("Write a blog on Java 8 Streams", TaskType.WRITING, LocalDate.of(2015, Month.JULY, 4)).addTag("blogging").addTag("writing").addTag("streams");

        Task task5 = new Task("Read Domain Driven Design book", TaskType.READING, LocalDate.of(2015, Month.JULY, 5)).addTag("ddd").addTag("books").addTag("reading");

        return Arrays.asList(task1, task2, task3, task4, task5);
    }
}
