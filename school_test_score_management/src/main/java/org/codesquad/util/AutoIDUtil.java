package org.codesquad.util;

public class AutoIDUtil {

    private static int studentId = 1001;
    private static int subjectId = 1001;

    public static String createStudentId() {
        return String.valueOf(studentId++);
    }

    public static String createStudentId(String id) {
        int number = Integer.parseInt(id);

        if (studentId < number) {
            studentId = number;
        }

        return String.valueOf(studentId++);
    }

    public static String createSubjectId() {
        return "subject" + subjectId++;
    }
}
