package org.codesquad.repository;

import org.codesquad.support.converter.FileToObject;
import org.codesquad.domain.Score;

import java.util.Collections;
import java.util.List;

public class FileScoreRepository implements ScoreRepository{

    private final List<Score> store;

    public FileScoreRepository() {
        FileToObject instance = FileToObject.getInstance();
        this.store = instance.getScoreList();
    }

    @Override
    public List<Score> findAll() {
        return Collections.unmodifiableList(store);
    }

    @Override
    public Score findById(String key) {
        return store.stream()
                .filter(score -> key.equals(score.getStudentId() + score.getSubjectId()))
                .findFirst()
                .orElseThrow();
    }

    @Override
    public Score save(Score score) {
        store.add(score);
        return score;
    }

    @Override
    public void update(Score score) {
        int index = store.indexOf(score);
        store.set(index, score);
    }

    @Override
    public void remove(Score score) {
        store.remove(score);
    }
}
