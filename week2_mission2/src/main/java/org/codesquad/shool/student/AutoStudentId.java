package org.codesquad.shool.student;

public class AutoStudentId {

    private static final AutoStudentId autoStudentId = new AutoStudentId();
    private static int studentId = 1003;

    private AutoStudentId() {

    }

    public static AutoStudentId getInstance() {
        return autoStudentId;
    }

    public int getStudentId() {
        return studentId++;
    }
}
