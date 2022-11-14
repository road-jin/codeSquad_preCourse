package org.codesquad.repository;

import org.codesquad.config.AppConfig;
import org.codesquad.domain.Score;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ScoreRepositoryTest {

    @Test
    void findAll() {
        // given
        AppConfig instance = AppConfig.getInstance();
        ScoreRepository scoreRepository = instance.getScoreRepository();

        // when
        List<Score> scoreList = scoreRepository.findAll();

        // then
        assertEquals(6, scoreList.size());
    }
}