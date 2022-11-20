package org.codesquad.service;

import org.codesquad.domain.Score;
import org.codesquad.domain.Student;
import org.codesquad.repository.ScoreRepository;
import org.codesquad.repository.StudentRepository;
import org.codesquad.service.dto.StudentScoreRequest;

import java.util.List;

public class StudentService {

    private final StudentRepository studentRepository;
    private final ScoreRepository scoreRepository;

    public StudentService(StudentRepository studentRepository, ScoreRepository scoreRepository) {
        this.studentRepository = studentRepository;
        this.scoreRepository = scoreRepository;
    }

    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    public String save(String name, String majorId, List<StudentScoreRequest> studentScoreRequestList) {
        String id = studentRepository.save(new Student(name, majorId)).getId();
        studentScoreRequestList.forEach(s -> scoreRepository.save(new Score(id, s.getSubjectId(), s.getScore())));
        return id;
    }
}
