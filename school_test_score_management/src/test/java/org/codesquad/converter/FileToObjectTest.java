package org.codesquad.converter;

import org.codesquad.domain.Score;
import org.codesquad.domain.Student;
import org.codesquad.domain.Subject;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FileToObjectTest {

    @Test
    void getStudentList() {
        // given
        FileToObject instance = FileToObject.getInstance();

        // when
        List<Student> studentList = instance.getStudentList();

        // then
        assertEquals(2, studentList.size());
    }

    @Test
    void getSubjectList() {
        // given
        FileToObject instance = FileToObject.getInstance();

        // when
        List<Subject> subjectList = instance.getSubjectList();

        // then
        assertEquals(3, subjectList.size());
    }

    @Test
    void getScoreList() {
        // given
        FileToObject instance = FileToObject.getInstance();

        // when
        List<Score> scoreList = instance.getScoreList();

        // then
        assertEquals(6, scoreList.size());
    }

}