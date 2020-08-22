package com.maistruk.characterscounter;

import static java.util.stream.Collectors.*;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Function;

public class UniqueCharsCounter implements CharsCounter {

    @Override
    public Map<Character, Integer> countCharacters(String text) {
        return text.chars().mapToObj(c -> (char) c).collect(groupingBy(
                Function.identity(),
                LinkedHashMap::new,
                summingInt(ch -> 1)));
    }
}
