package org.codesquad.support.grade;

public class BasicEvaluation implements GradeEvaluation {

    @Override
    public String getGrade(String score) {
        int scoreInteger = Integer.parseInt(score);

        if (scoreInteger >= 90) {
            return "A";
        }

        if (scoreInteger >= 80) {
            return "B";
        }

        if (scoreInteger >= 70) {
            return "C";
        }

        if (scoreInteger >= 55) {
            return "D";
        }

        return "F";
    }
}
