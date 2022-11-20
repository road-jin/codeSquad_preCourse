package org.codesquad.support.grade;

import org.codesquad.domain.Major;
import org.codesquad.domain.Subject;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public enum GradeEvaluations {

    BASIC(Collections.emptyList(), new BasicEvaluation()),
    MAJOR(Collections.emptyList(), new MajorEvaluation()),
    PASS_AND_FAIL(List.of("방송댄스"), new PassAndFailEvaluation());

    private List<String> subjectList;
    private GradeEvaluation gradeEvaluation;

    GradeEvaluations(List<String> subjectList, GradeEvaluation gradeEvaluation) {
        this.subjectList = subjectList;
        this.gradeEvaluation = gradeEvaluation;
    }

    public static GradeEvaluation getInstance(Major major, Subject subject) {
        Optional<GradeEvaluations> gradeEvaluations = Arrays.stream(values())
                .filter(value -> !value.subjectList.isEmpty())
                .toList()
                .stream()
                .filter(value -> value.subjectList.contains(subject.getName()))
                .findFirst();

        if (gradeEvaluations.isPresent()) {
            return gradeEvaluations.get().gradeEvaluation;
        }

        if (subject.isEqualsId(major.getRequiredSubjectId())) {
            return MAJOR.gradeEvaluation;
        }

        return BASIC.gradeEvaluation;
    }
}
