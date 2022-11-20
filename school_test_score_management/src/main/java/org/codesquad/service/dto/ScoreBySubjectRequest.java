package org.codesquad.service.dto;

public class ScoreBySubjectRequest {

    private final String studentId;
    private final String score;

    public ScoreBySubjectRequest(String studentId, String score) {
        this.studentId = studentId;
        this.score = score;
    }

    public String getStudentId() {
        return studentId;
    }

    public String getScore() {
        return score;
    }
}
