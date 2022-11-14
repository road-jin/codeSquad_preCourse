package org.codesquad.service;

import org.codesquad.domain.Score;
import org.codesquad.repository.ScoreRepository;

import java.util.List;
import java.util.stream.Stream;

public class ScoreService {

    private final ScoreRepository scoreRepository;

    public ScoreService(ScoreRepository scoreRepository) {
        this.scoreRepository = scoreRepository;
    }

    public List<Score> save(List<Score> scoreList) {
        scoreList.forEach(scoreRepository::save);
        return scoreList;
    }

    public Score findById(String studentIdAndSubjectId) {
        return scoreRepository.findById(studentIdAndSubjectId);
    }

    public int totalScore(String studentId) {
        return  findByStudentIdAndIsNotXScore(studentId)
                .mapToInt(student -> Integer.parseInt(student.getScore()))
                .sum();
    }

    public double average(String studentId) {
        return findByStudentIdAndIsNotXScore(studentId)
                .mapToInt(student -> Integer.parseInt(student.getScore()))
                .average()
                .orElseThrow();
    }

    public int subjectCount (String studentId) {
        return (int) findByStudentIdAndIsNotXScore(studentId)
                .count();
    }

    public void update(List<Score> scoreList) {
        scoreList.forEach(score -> scoreRepository.update(score));
    }

    private Stream<Score> findByStudentIdAndIsNotXScore(String studentId) {
        return scoreRepository.findAll()
                .stream()
                .filter(score -> score.isEqualsStudentId(studentId) &&
                        score.isNotXScore());
    }

}
