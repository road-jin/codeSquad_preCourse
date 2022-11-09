package org.codesquad.wordchain;

import java.util.HashSet;
import java.util.Set;

public class WordChainGame {

    private final Set<String> checkWord;
    private String[] names;

    public WordChainGame() {
        this.checkWord = new HashSet<>();
    }

    public void run() {
        ready();
        addUser();
        playUser(0, "기러기");
        gameOver();
    }

    private void ready() {
        checkWord.add("기러기");
        WordChainView.init();
    }

    private void addUser() {
        int userCount = WordChainView.getUserCount();
        names = WordChainView.getUserNames(userCount);
    }

    private void playUser(int nameIndex, String inputWord) {
        Word word = new Word(inputWord);
        String answerWord = WordChainView.getWord(names[nameIndex]);

        if (word.isWordCheck(answerWord) && !checkWord.contains(answerWord)) {
            checkWord.add(answerWord);
            int nextNameIndex = (nameIndex + 1) % names.length;
            playUser(nextNameIndex, answerWord);
        }
    }

    private void gameOver() {
        int index = (checkWord.size() - 1) % names.length;
        WordChainView.gameOver(names[index]);
    }
}
