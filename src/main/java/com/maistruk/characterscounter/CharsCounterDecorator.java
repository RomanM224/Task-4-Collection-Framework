package com.maistruk.characterscounter;

import java.util.Map;

public abstract class CharsCounterDecorator implements CharsCounter {

    protected CharsCounter charsCounter;

    public CharsCounterDecorator(CharsCounter charsCounter) {
        this.charsCounter = charsCounter;
    }

    public Map<Character, Integer> countCharacters(String text) {
        return charsCounter.countCharacters(text);
    }
}
