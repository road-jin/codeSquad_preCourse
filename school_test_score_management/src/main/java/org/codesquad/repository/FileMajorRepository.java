package org.codesquad.repository;

import org.codesquad.support.converter.FileToObject;
import org.codesquad.domain.Major;

import java.util.Collections;
import java.util.List;

public class FileMajorRepository implements MajorRepository {

    private final List<Major> store;

    public FileMajorRepository() {
        FileToObject instance = FileToObject.getInstance();
        this.store = instance.getMajorList();
    }

    @Override
    public List<Major> findAll() {
        return Collections.unmodifiableList(store);
    }

    @Override
    public Major findById(String majorId) {
        return store.stream()
                .filter(major -> major.isEqualsId(majorId))
                .findFirst()
                .orElseThrow();
    }

    @Override
    public Major save(Major major) {
        store.add(major);
        return major;
    }

    @Override
    public void update(Major major) {
        int index = store.indexOf(major);
        store.set(index, major);
    }

    @Override
    public void remove(Major major) {
        store.remove(major);
    }
}
