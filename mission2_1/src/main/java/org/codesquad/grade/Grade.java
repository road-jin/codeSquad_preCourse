package org.codesquad.grade;

public class Grade {

    private final Integer mathScore;
    private final Integer scienceScore;
    private final Integer englishScore;

    public Grade(Integer mathScore, Integer scienceScore, Integer englishScore) {
        this.mathScore = mathScore;
        this.scienceScore = scienceScore;
        this.englishScore = englishScore;
    }

    public int scoreAverage() {
        return (mathScore + scienceScore + englishScore) / 3;
    }
}
