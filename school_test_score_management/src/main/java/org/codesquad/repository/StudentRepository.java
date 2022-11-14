package org.codesquad.repository;

import org.codesquad.domain.Student;

import java.util.List;

public interface StudentRepository {

    List<Student> findAll();

    Student findById(String studentId);

    Student save(Student student);

    void update(Student student);

    void remove(Student student);
}
