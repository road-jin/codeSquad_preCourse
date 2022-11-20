package org.codesquad.support.grade;

public class MajorEvaluation implements GradeEvaluation {

    @Override
    public String getGrade(String score) {
        int scoreInteger = Integer.parseInt(score);

        if (scoreInteger >= 95) {
            return "S";
        }

        if (scoreInteger >= 90) {
            return "A";
        }

        if (scoreInteger >= 80) {
            return "B";
        }

        if (scoreInteger >= 70) {
            return "C";
        }

        if (scoreInteger >= 60) {
            return "D";
        }

        return "F";
    }
}
