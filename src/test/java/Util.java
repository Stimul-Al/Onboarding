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

    public static String infoStudents (){
        return "Math: (Nik: 8, Alex: 10, David: 7)\n" +
                "Physic: (Nik: 8, Alex: 9, David: 6)\n" +
                "English: (Nik: 8, Alex: 8, David: 6)";
    }

    public static String groupById() {
        return "{CODING=[Task(id=CODING, title=Write a mobile application to store my tasks, type=CODING, createdOn=2015-07-03, done=false, tags=[coding, mobile], dueTo=null)], WRITING=[Task(id=WRITING, title=Write a blog on Java 8 Streams, type=WRITING, createdOn=2015-07-04, done=false, tags=[blogging, writing, streams], dueTo=null)], READING=[Task(id=READING, title=Read Version Control with Git book, type=READING, createdOn=2015-07-01, done=false, tags=[git, books, reading], dueTo=null), Task(id=READING, title=Read Java 8 Lambdas book, type=READING, createdOn=2015-07-02, done=false, tags=[books, java8, reading], dueTo=null), Task(id=READING, title=Read Domain Driven Design book, type=READING, createdOn=2015-07-05, done=false, tags=[books, ddd, reading], dueTo=null)]}";
    }

    public static String groupByTitle() {
        return "{Write a blog on Java 8 Streams=[Task(id=WRITING, title=Write a blog on Java 8 Streams, type=WRITING, createdOn=2015-07-04, done=false, tags=[blogging, writing, streams], dueTo=null)], Read Domain Driven Design book=[Task(id=READING, title=Read Domain Driven Design book, type=READING, createdOn=2015-07-05, done=false, tags=[books, ddd, reading], dueTo=null)], Read Java 8 Lambdas book=[Task(id=READING, title=Read Java 8 Lambdas book, type=READING, createdOn=2015-07-02, done=false, tags=[books, java8, reading], dueTo=null)], Write a mobile application to store my tasks=[Task(id=CODING, title=Write a mobile application to store my tasks, type=CODING, createdOn=2015-07-03, done=false, tags=[coding, mobile], dueTo=null)], Read Version Control with Git book=[Task(id=READING, title=Read Version Control with Git book, type=READING, createdOn=2015-07-01, done=false, tags=[git, books, reading], dueTo=null)]}";
    }

    public static String groupByType() {
        return "{WRITING=[Task(id=WRITING, title=Write a blog on Java 8 Streams, type=WRITING, createdOn=2015-07-04, done=false, tags=[blogging, writing, streams], dueTo=null)], READING=[Task(id=READING, title=Read Version Control with Git book, type=READING, createdOn=2015-07-01, done=false, tags=[git, books, reading], dueTo=null), Task(id=READING, title=Read Java 8 Lambdas book, type=READING, createdOn=2015-07-02, done=false, tags=[books, java8, reading], dueTo=null), Task(id=READING, title=Read Domain Driven Design book, type=READING, createdOn=2015-07-05, done=false, tags=[books, ddd, reading], dueTo=null)], CODING=[Task(id=CODING, title=Write a mobile application to store my tasks, type=CODING, createdOn=2015-07-03, done=false, tags=[coding, mobile], dueTo=null)]}";
    }

    public static String groupByDate() {
        return "{2015-07-04=[Task(id=WRITING, title=Write a blog on Java 8 Streams, type=WRITING, createdOn=2015-07-04, done=false, tags=[blogging, writing, streams], dueTo=null)], 2015-07-05=[Task(id=READING, title=Read Domain Driven Design book, type=READING, createdOn=2015-07-05, done=false, tags=[books, ddd, reading], dueTo=null)], 2015-07-02=[Task(id=READING, title=Read Java 8 Lambdas book, type=READING, createdOn=2015-07-02, done=false, tags=[books, java8, reading], dueTo=null)], 2015-07-03=[Task(id=CODING, title=Write a mobile application to store my tasks, type=CODING, createdOn=2015-07-03, done=false, tags=[coding, mobile], dueTo=null)], 2015-07-01=[Task(id=READING, title=Read Version Control with Git book, type=READING, createdOn=2015-07-01, done=false, tags=[git, books, reading], dueTo=null)]}";
    }
}
