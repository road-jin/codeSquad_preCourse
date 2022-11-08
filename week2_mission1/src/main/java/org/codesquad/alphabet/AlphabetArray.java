package org.codesquad.alphabet;

import java.util.ArrayList;

public class AlphabetArray {

    private ArrayList<Character> arr;

    public AlphabetArray() {
        this.arr = save();
    }

    private ArrayList<Character> save() {
        int alphabetSize = 26;
        arr = new ArrayList<>();

        for (int i = 0; i < alphabetSize; i++) {
            arr.add((char) (65 + i));
        }

        return arr;
    }

    public void print() {
        arr.forEach(System.out::println);
    }
}