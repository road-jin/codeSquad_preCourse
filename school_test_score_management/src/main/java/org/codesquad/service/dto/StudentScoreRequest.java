package org.codesquad.service.dto;

public class StudentScoreRequest {

    private final String subjectId;
    private final String score;

    public StudentScoreRequest(String subjectId, String score) {
        this.subjectId = subjectId;
        this.score = score;
    }

    public String getSubjectId() {
        return subjectId;
    }

    public String getScore() {
        return score;
    }
}
