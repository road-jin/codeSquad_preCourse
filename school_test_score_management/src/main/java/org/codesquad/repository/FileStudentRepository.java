package org.codesquad.repository;

import org.codesquad.domain.Student;
import org.codesquad.support.converter.FileToObject;

import java.util.Collections;
import java.util.List;

public class FileStudentRepository implements StudentRepository{

    private final List<Student> store;

    public FileStudentRepository() {
        FileToObject fileToObject = FileToObject.getInstance();
        this.store = fileToObject.getStudentList();
    }

    @Override
    public List<Student> findAll() {
        return Collections.unmodifiableList(store);
    }

    @Override
    public Student findById(String studentId) {
        return store.stream()
                .filter(student -> student.isEqualsId(studentId))
                .findFirst()
                .orElseThrow();
    }

    @Override
    public Student save(Student student) {
        store.add(student);
        return student;
    }

    @Override
    public void update(Student student) {
        int index = store.indexOf(student);
        store.set(index, student);
    }

    @Override
    public void remove(Student student) {
        store.remove(student);
    }
}
