package by.leverx.task_one.service.impl;

import by.leverx.task_one.model.Person;
import by.leverx.task_one.model.Skill;
import by.leverx.task_one.service.PersonService;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toMap;

public class PersonServiceImpl implements PersonService {

    @Override
    public String findBestMatchingPerson(List<Person> persons, Skill... skills) {
        return Arrays.stream(skills).map(skill -> "\"" + skill.getName() + "\": " +
                        "\"" + getNameByMaxSkill(persons, skill) + "\"")
                .collect(joining(", ", "[", "]"));
    }

    private String getNameByMaxSkill(List<Person> persons, Skill skill) {
        Map<String, Long> mapPersonsPercentSkill = getMapPersons(persons, skill);
        Long maxPercentSkill = maxPercentSkill(mapPersonsPercentSkill);

        return mapPersonsPercentSkill.entrySet().stream()
                .filter(entry -> entry.getValue().equals(maxPercentSkill))
                .filter(entry -> entry.getValue() != 0)
                .map(Map.Entry::getKey)
                .findFirst().orElse(null);
    }

    private Map<String, Long> getMapPersons(List<Person> persons, Skill skill) {
        return persons.stream().collect(toMap(
                Person::getName, person -> getPercentageSkill(person, skill)));
    }

    private Long maxPercentSkill(Map<String, Long> map) {
        return map.values().stream()
                .max(Long::compare).orElse(0L);
    }

    private Long getPercentageSkill(Person person, Skill skill) {
        return person.getSkills().stream()
                .filter(personsSkill -> personsSkill.getName().equals(skill.getName()))
                .map(Skill::getKnowPercentage)
                .findFirst().orElse(0L);
    }
}
