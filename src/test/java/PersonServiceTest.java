import by.leverx.task_one.model.Person;
import by.leverx.task_one.model.Skill;
import by.leverx.task_one.service.PersonService;
import by.leverx.task_one.service.impl.PersonServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import util.Util;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static util.Util.getPersons;
import static util.Util.getPersonsOfSkills;

public class PersonServiceTest {

    private PersonService personService;

    @BeforeEach
    void init() {
        personService = new PersonServiceImpl();
    }

    @Test
    void testFindBestMatchingPerson_happyPath() {
        //given
        List<Person> persons = getPersons();
        String expectedSkills = getPersonsOfSkills();

        //when
        String actualSkills = personService.
                findBestMatchingPerson(persons, new Skill("English", 50),
                                                new Skill("Kannada", 50),
                                                new Skill("Urdu", 50),
                                                new Skill("Hindi", 50));

        //then
        assertEquals(expectedSkills, actualSkills);
    }
}
