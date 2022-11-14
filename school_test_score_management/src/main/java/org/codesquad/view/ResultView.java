package org.codesquad.view;

import org.codesquad.domain.Score;
import org.codesquad.domain.Student;
import org.codesquad.domain.Subject;
import org.codesquad.service.ScoreService;
import org.codesquad.service.SubjectService;

import java.text.DecimalFormat;
import java.util.List;

public class ResultView {

    public static void scoreView(List<Student> studentList, ScoreService scoreService) {
        DecimalFormat decimalFormat = new DecimalFormat("#.##");

        studentList.stream()
                .forEach(student -> {
                    String id = student.getId();
                    System.out.printf("%s학생은 %s과목을 수강했습니다.\n총점은 %d이고 평균은 %s점 입니다.\n\n",
                            student.getName(), scoreService.subjectCount(id), scoreService.totalScore(id),
                            decimalFormat.format(scoreService.average(id)));
        });
    }

    public static void studentDetailView(List<Student> studentList, SubjectService subjectService, ScoreService scoreService) {
        List<Subject> subjectList = subjectService.findAll();
        studentList.stream()
                .forEach(student -> {
                    String subjectName = appendSubjectName(subjectService, student.getRequiredSubjectIdList());
                    String scoreList = appendScore(scoreService, subjectList, student.getId());
                    System.out.printf("| 이름 : %s | 학번 : %s | 전공과목 :%s%s\n",
                            student.getName(), student.getId(), subjectName, scoreList);

        });
    }

    private static String appendSubjectName(SubjectService subjectService, List<String> requiredSubjectIdList) {
        StringBuilder stringBuilder = new StringBuilder();
        requiredSubjectIdList.forEach(subjectId -> {
            Subject subject = subjectService.findById(subjectId);
            stringBuilder.append(" ")
                    .append(subject.getName());
            }
        );

        return stringBuilder.toString();
    }

    private static String appendScore(ScoreService scoreService, List<Subject> subjectList, String studentId) {
        StringBuilder stringBuilder = new StringBuilder();
        subjectList.forEach(subject -> {
            String key = studentId + subject.getId();
            Score score = scoreService.findById(key);
            stringBuilder.append(" | ")
                    .append(subject.getName())
                    .append(" : ")
                    .append(score.getScore());
        });

        return stringBuilder.toString();
    }
}
