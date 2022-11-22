package org.codesquad.grade;

import java.util.Arrays;

public enum GradeConverter {

    A("A", 4.0),
    B("B", 3.0),
    C("C", 2.0),
    D("D", 1.0),
    F("F", 0.0);

    private String grade;
    private double score;

    public double getScore() {
        return score;
    }

    GradeConverter(String grade, double score) {
        this.grade = grade;
        this.score = score;
    }

    public static GradeConverter findByGrade(String grade) {
        return Arrays.stream(values())
                .filter(g -> g.grade.equals(grade))
                .findFirst()
                .orElseThrow();
    }
}
