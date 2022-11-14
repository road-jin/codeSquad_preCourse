package org.codesquad.domain;

import java.util.Objects;

public class Score {

    private final String studentId;
    private final String subjectId;
    private final String score;

    public Score(String studentId, String subjectId, String score) {
        this.studentId = studentId;
        this.subjectId = subjectId;
        this.score = score;
    }

    public String getStudentId() {
        return studentId;
    }

    public String getSubjectId() {
        return subjectId;
    }

    public String getScore() {
        return score;
    }

    public boolean isEqualsStudentId(String studentId) {
        return this.studentId.equals(studentId);
    }

    public boolean isNotXScore() {
        return !this.score.equalsIgnoreCase("X");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Score score = (Score) o;
        return getStudentId().equals(score.getStudentId()) && getSubjectId().equals(score.getSubjectId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getStudentId(), getSubjectId());
    }
}
