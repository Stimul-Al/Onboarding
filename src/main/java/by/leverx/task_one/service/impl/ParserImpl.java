package by.leverx.task_one.service.impl;

import by.leverx.task_one.service.Parser;

import java.util.*;

import static java.util.stream.Collectors.*;

public class ParserImpl implements Parser {

    @Override
    public String func(String str) {
        return getMapLetterToNumberTimes(str)
                .entrySet().stream()
                .filter(entry -> entry.getValue().equals(this.max(str)))
                .map(entry -> entry.getKey() + ": " + entry.getValue())
                .collect(joining(", "));
    }

    private Map<Character, Long> getMapLetterToNumberTimes(String str) {
        return str.chars()
                .mapToObj(item -> (char) item)
                .distinct()
                .collect(toMap(item -> item,
                        item -> listItems(str).stream()
                                .filter(item::equals)
                                .count()));
    }

    private Long max(String str) {
        return getMapLetterToNumberTimes(str).values()
                .stream()
                .max(Long::compare).orElse(0L);
    }

    private List<Character> listItems(String str) {
        return str.chars()
                .mapToObj(item -> (char) item)
                .collect(toList());
    }
}
