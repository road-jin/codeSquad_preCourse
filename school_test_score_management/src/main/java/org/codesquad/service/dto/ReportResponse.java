package org.codesquad.service.dto;

public class ReportResponse {

    private final String studentId;
    private final String studentName;
    private final String requiredSubjectName;
    private final String score;
    private final String grade;
    private final String subjectName;

    public ReportResponse(String studentId, String studentName, String requiredSubjectName, String score, String grade, String subjectName) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.requiredSubjectName = requiredSubjectName;
        this.score = score;
        this.grade = grade;
        this.subjectName = subjectName;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public String getStudentId() {
        return studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public String getRequiredSubjectName() {
        return requiredSubjectName;
    }

    public String getScore() {
        return score;
    }

    public String getGrade() {
        return grade;
    }
}
