package org.codesquad.util;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AutoIDUtilTest {

    @Test
    void createStudentId() {
        // given

        // when
        String studentId1 = AutoIDUtil.createStudentId();
        String studentId2 = AutoIDUtil.createStudentId();

        // then
        Assertions.assertEquals("1001", studentId1);
        Assertions.assertEquals("1002", studentId2);
    }

    @Test
    void createSubjectId() {
        // given

        // when
        String subjectId1 = AutoIDUtil.createSubjectId();
        String subjectId2 = AutoIDUtil.createSubjectId();

        // then
        Assertions.assertEquals("subject1001", subjectId1);
        Assertions.assertEquals("subject1002", subjectId2);
    }
}
