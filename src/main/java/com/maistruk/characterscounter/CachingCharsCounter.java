package com.maistruk.characterscounter;

import java.util.HashMap;
import java.util.Map;

public class CachingCharsCounter extends CharsCounterDecorator {

    private Map<String, Map<Character, Integer>> cache = new HashMap<String, Map<Character, Integer>>();

    public CachingCharsCounter(CharsCounter charsCounter) {
        super(charsCounter);
    }

    public Map<Character, Integer> countCharacters(String text) {
        return cache.computeIfAbsent(text, key -> charsCounter.countCharacters(key));
    }
}
