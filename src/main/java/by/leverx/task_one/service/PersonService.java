package by.leverx.task_one.service;

import by.leverx.task_one.model.Person;
import by.leverx.task_one.model.Skill;

import java.util.List;

public interface PersonService {

    String findBestMatchingPerson(List<Person> persons, Skill... skills);
}
