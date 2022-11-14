package org.codesquad.repository;

import org.codesquad.domain.Subject;

import java.util.List;

public interface SubjectRepository {

    List<Subject> findAll();

    Subject findById(String subjectId);

    Subject save(Subject subject);

    void update(Subject subject);

    void remove(Subject subject);
}
