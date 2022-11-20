package org.codesquad.support.grade;

public class PassAndFailEvaluation implements GradeEvaluation{

    @Override
    public String getGrade(String score) {
        if (Integer.parseInt(score) >= 70) {
            return "P";
        }

        return "F";
    }
}
