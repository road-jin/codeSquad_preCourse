package org.codesquad.converter;

import org.codesquad.config.AppConfig;
import org.codesquad.domain.Score;
import org.codesquad.domain.Student;
import org.codesquad.domain.Subject;
import org.codesquad.repository.ScoreRepository;
import org.codesquad.repository.StudentRepository;
import org.codesquad.repository.SubjectRepository;

import java.util.List;

public class ObjectToFile {
    
    private static final ObjectToFile objectToFile = new ObjectToFile();
    
    private final StudentRepository studentRepository;
    private final SubjectRepository subjectRepository;
    private final ScoreRepository scoreRepository;
    
    private ObjectToFile() {
        AppConfig appconfig = AppConfig.getInstance();
        this.studentRepository = appconfig.getStudentRepository();
        this.subjectRepository = appconfig.getSubjectRepository();
        this.scoreRepository = appconfig.getScoreRepository();
    }
    
    public static ObjectToFile getInstance() {
        return objectToFile;
    }

    public String getWriteString() {
        List<Student> studentList = studentRepository.findAll();
        List<Subject> subjectList = subjectRepository.findAll();

        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append("이름 학번 전공과목");
        subjectList.forEach(subject -> stringBuilder.append(" ").append(subject.getName()));
        stringBuilder.append("\n");

        studentList.forEach(student -> {
            stringBuilder.append(student.getName());
            stringBuilder.append(" ").append(student.getId());

            List<String> requiredSubjectIdList = student.getRequiredSubjectIdList();
            addRequiredSubjectName(stringBuilder, requiredSubjectIdList);
            addScore(stringBuilder, student.getId());
            stringBuilder.append("\n");
        });

        return stringBuilder.toString();
    }

    private void addRequiredSubjectName(StringBuilder stringBuilder, List<String> requiredSubjectIdList) {
        requiredSubjectIdList.forEach(requiredSubjectId -> {
            Subject findSubject = subjectRepository.findById(requiredSubjectId);
            stringBuilder.append(" ").append(findSubject.getName());
        });
    }

    private void addScore(StringBuilder stringBuilder, String studentId) {
        List<Subject> subjectList = subjectRepository.findAll();

        subjectList.forEach(subject -> {
            Score findScore = scoreRepository.findById(studentId + subject.getId());
            String result = addScoreEmpty(findScore);
            stringBuilder.append(" ").append(result);
        });
    }

    private String addScoreEmpty(Score score) {
        if (score.isNotXScore()) {
            return score.getScore();
        }

        return " ";
    }
}
