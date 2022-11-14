package org.codesquad.service;

import org.codesquad.domain.Subject;
import org.codesquad.repository.SubjectRepository;

import java.util.List;

public class SubjectService {

    private final SubjectRepository subjectRepository;

    public SubjectService(SubjectRepository subjectRepository) {
        this.subjectRepository = subjectRepository;
    }

    public List<Subject> findAll() {
        return subjectRepository.findAll();
    }

    public Subject findById(String subjectId) {
        return subjectRepository.findById(subjectId);
    }
}
