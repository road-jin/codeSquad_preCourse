package org.codesquad.service;

import org.codesquad.domain.Score;
import org.codesquad.domain.Subject;
import org.codesquad.repository.ScoreRepository;
import org.codesquad.repository.SubjectRepository;
import org.codesquad.service.dto.ScoreBySubjectRequest;

import java.util.List;

public class SubjectService {

    private final SubjectRepository subjectRepository;
    private final ScoreRepository scoreRepository;

    public SubjectService(SubjectRepository subjectRepository, ScoreRepository scoreRepository) {
        this.subjectRepository = subjectRepository;
        this.scoreRepository = scoreRepository;
    }

    public List<Subject> findAll() {
        return subjectRepository.findAll();
    }

    public String save(String name, List<ScoreBySubjectRequest> scoreBySubjectRequestList) {
        Subject subject = subjectRepository.save(new Subject(name));
        scoreBySubjectRequestList.forEach(s -> scoreRepository.save(new Score(s.getStudentId(), subject.getId(), s.getScore())));
        return subject.getId();
    }
}
