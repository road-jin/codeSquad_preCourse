package org.codesquad.service;

import org.codesquad.converter.FileToObject;
import org.codesquad.converter.ObjectToFile;
import org.codesquad.domain.Student;
import org.codesquad.repository.StudentRepository;

import java.util.List;

public class StudentService {

    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    public Student findById(String studentId) {
        return studentRepository.findById(studentId);
    }

    public Student save(String name, List<String> requiredSubjectIdList) {
        Student saveStudent = studentRepository.save(new Student(name, requiredSubjectIdList));
        return saveStudent;
    }
}
