package com.maistruk.characterscounter;

import static org.junit.jupiter.api.Assertions.*;

import java.util.LinkedHashMap;
import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class UniqueCharsCounterTest {

    private CharsCounter charsCounter;

    @BeforeEach
    public void setUp() {
        charsCounter = new UniqueCharsCounter();
    }

    @Test
    public void givenTexthello_whenCountedUniqueChars_thenGetAmountOfChars() {
        Map<Character, Integer> expected = new LinkedHashMap<Character, Integer>();
        expected.put('h', 1);
        expected.put('e', 1);
        expected.put('l', 2);
        expected.put('o', 1);

        Map<Character, Integer> actual = charsCounter.countCharacters("hello");

        assertEquals(expected, actual);
    }

    @Test
    public void givenTextHelloWorld_whenCountedUniqueChars_thenGetAmountOfChars() {
        Map<Character, Integer> expected = new LinkedHashMap<Character, Integer>();
        expected.put('H', 1);
        expected.put('e', 1);
        expected.put('l', 3);
        expected.put('o', 2);
        expected.put(' ', 1);
        expected.put('W', 1);
        expected.put('r', 1);
        expected.put('d', 1);
        expected.put('!', 1);

        Map<Character, Integer> actual = charsCounter.countCharacters("Hello World!");

        assertEquals(expected, actual);
    }

    @Test
    public void givenTextBlankSpaces_whenCountedUniqueChars_thenGetAmountOfChars() {
        Map<Character, Integer> expected = new LinkedHashMap<Character, Integer>();
        expected.put(' ', 5);

        Map<Character, Integer> actual = charsCounter.countCharacters("     ");

        assertEquals(expected, actual);
    }

    @Test
    public void givenTextWithSpaces_whenCountedUniqueChars_thenGetAmountOfChars() {
        Map<Character, Integer> expected = new LinkedHashMap<Character, Integer>();
        expected.put('a', 2);
        expected.put(' ', 4);
        expected.put('A', 2);
        expected.put('b', 1);

        Map<Character, Integer> actual = charsCounter.countCharacters("a A A a b");

        assertEquals(expected, actual);
    }
}
