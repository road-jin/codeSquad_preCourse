package org.codesquad.repository;

import org.codesquad.domain.Score;
import org.codesquad.domain.Subject;

import java.util.List;

public interface ScoreRepository {

    List<Score> findAll();

    Score findById(String studentIdAndSubjectId);

    Score save(Score score);

    void update(Score score);

    void remove(Score score);
}
