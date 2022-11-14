package org.codesquad.repository;

import org.codesquad.config.AppConfig;
import org.codesquad.domain.Student;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

public class StudentRepositoryTest {

    @Test
    void findAll() {
        // given
        AppConfig instance = AppConfig.getInstance();
        StudentRepository studentRepository = instance.getStudentRepository();

        // when
        List<Student> studentList = studentRepository.findAll();
        Student student1 = studentList.get(0);
        Student student2 = studentList.get(1);

        // then
        assertEquals("1001", student1.getId());
        assertEquals("1002", student2.getId());

        assertEquals("Kim", student1.getName());
        assertEquals("Lee", student2.getName());

        assertEquals(List.of("subject1002"), student1.getRequiredSubjectIdList());
        assertEquals(List.of("subject1001"), student2.getRequiredSubjectIdList());
    }
}
