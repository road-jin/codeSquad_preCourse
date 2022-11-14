package org.codesquad.repository;

import org.codesquad.config.AppConfig;
import org.codesquad.domain.Subject;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

public class SubjectRepositoryTest {

    @Test
    void findAll() {
        // given
        AppConfig instance = AppConfig.getInstance();
        SubjectRepository subjectRepository = instance.getSubjectRepository();

        // when
        List<Subject> subjectList = subjectRepository.findAll();
        Subject subject1 = subjectList.get(0);
        Subject subject2 = subjectList.get(1);
        Subject subject3 = subjectList.get(2);

        // then
        assertEquals("subject1001", subject1.getId());
        assertEquals("subject1002", subject2.getId());
        assertEquals("subject1003", subject3.getId());

        assertEquals("국어", subject1.getName());
        assertEquals("수학", subject2.getName());
        assertEquals("영어", subject3.getName());
    }
}
