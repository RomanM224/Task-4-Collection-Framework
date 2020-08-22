package com.maistruk.characterscounter;

import static org.mockito.Mockito.*;

import java.util.LinkedHashMap;
import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.maistruk.characterscounter.CharsCounter;

public class CachingCharsCounterTest {

    private CharsCounter charsCounter;
    private CharsCounter cachingCharsCounter;
    
    @BeforeEach
    public void setUp() {
        charsCounter = mock(CharsCounter.class);
        cachingCharsCounter = new CachingCharsCounter(charsCounter);
    }
    
    @Test
    public void givenhelloTwice_whenCountCharacters_thenDelegatedCounterCalledOnce() {
        Map<Character, Integer> result = new LinkedHashMap<Character, Integer>();
        result.put('h', 1);
        result.put('e', 1);
        result.put('l', 2);
        result.put('o', 1);
        String text = "hello";
        when(charsCounter.countCharacters(text)).thenReturn(result);
        
        cachingCharsCounter.countCharacters(text);
        cachingCharsCounter.countCharacters(text);
        
        verify(charsCounter, times(1)).countCharacters(text);
    }
}
