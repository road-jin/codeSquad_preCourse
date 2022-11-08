package org.codesquad.wordchain;

public class Word {
    private final String word;

    public Word(String word) {
        this.word = word;
    }

    public boolean isWordCheck(String answerWord) {
        String lastWord = getLastWord(word);
        String firstWord = answerWord.substring(0,1);
        return lastWord.equals(firstWord);
    }

    public static String getLastWord(String word) {
        int length = word.length();
        return word.substring(length - 1, length);
    }
}
