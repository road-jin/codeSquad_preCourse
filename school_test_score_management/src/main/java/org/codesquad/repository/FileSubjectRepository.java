package org.codesquad.repository;

import org.codesquad.domain.Subject;
import org.codesquad.converter.FileToObject;

import java.util.List;

public class FileSubjectRepository implements SubjectRepository{

    private final List<Subject> store;

    public FileSubjectRepository() {
        FileToObject instance = FileToObject.getInstance();
        this.store = instance.getSubjectList();
    }

    @Override
    public List<Subject> findAll() {
        return store;
    }

    @Override
    public Subject findById(String subjectId) {
        return store.stream()
                .filter(subject -> subject.getId().equals(subjectId))
                .findFirst()
                .orElseThrow();
    }

    @Override
    public Subject save(Subject subject) {
        store.add(subject);
        return subject;
    }

    @Override
    public void update(Subject subject) {
        int index = store.indexOf(subject);
        store.set(index, subject);
    }

    @Override
    public void remove(Subject subject) {
        store.remove(subject);
    }
}
