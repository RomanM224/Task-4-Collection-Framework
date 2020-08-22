package com.maistruk.characterscounter;

import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        CharsCounter processingCharacters = new CachingCharsCounter(new UniqueCharsCounter());
        Scanner scanner = new Scanner(System.in);
        String text = "";
        while (!text.equals("y")) {
            System.out.print("Enter text: ");
            text = scanner.nextLine();
            System.out.println(text);
            buildResult(processingCharacters.countCharacters(text));
            System.out.println("Close program? (write 'y' if wanto close)");
            text = scanner.nextLine();
        } 
    }

    public static void buildResult(Map<Character, Integer> result) {
        for (Map.Entry<Character, Integer> entry : result.entrySet()) {
            System.out.println("\"" + entry.getKey() + "\" - " + entry.getValue());
        }
    }
}
