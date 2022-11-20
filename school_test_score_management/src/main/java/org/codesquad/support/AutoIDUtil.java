package org.codesquad.support;

import java.time.LocalDate;

public class AutoIDUtil {

    private static int studentId = 1;
    private static int subjectId = 1;
    private static int majorId = 1;

    public static String createStudentId() {
        LocalDate now = LocalDate.now();
        int year = now.getYear() - 2000;
        String format = String.format("%04d", studentId++);
        return year + format;
    }

    public static String createStudentId(String id) {
        LocalDate now = LocalDate.now();
        int nowYear = now.getYear() - 2000;
        int year = Integer.parseInt(id.substring(0, 2));
        int seq = Integer.parseInt(id.substring(2));

        if (nowYear == year && studentId < seq) {
            studentId = seq;
            String format = String.format("%04d", studentId++);
            return nowYear + format;
        }

        return id;
    }

    public static String createSubjectId() {
        return "subject" + String.format("%04d", subjectId++);
    }

    public static String createMajorId() {
        return "major" + String.format("%04d", majorId++);
    }
}
