package org.codesquad.support.converter;

import org.codesquad.config.AppConfig;
import org.codesquad.domain.Major;
import org.codesquad.domain.Score;
import org.codesquad.domain.Student;
import org.codesquad.domain.Subject;
import org.codesquad.repository.MajorRepository;
import org.codesquad.repository.ScoreRepository;
import org.codesquad.repository.StudentRepository;
import org.codesquad.repository.SubjectRepository;

import java.util.List;

public class ObjectToFile {
    
    private static final ObjectToFile objectToFile = new ObjectToFile();
    
    private final StudentRepository studentRepository;
    private final SubjectRepository subjectRepository;
    private final ScoreRepository scoreRepository;
    private final MajorRepository majorRepository;
    private final StringBuilder stringBuilder;
    
    private ObjectToFile() {
        AppConfig appconfig = AppConfig.getInstance();
        this.studentRepository = appconfig.getStudentRepository();
        this.subjectRepository = appconfig.getSubjectRepository();
        this.scoreRepository = appconfig.getScoreRepository();
        this.majorRepository = appconfig.getMajorRepository();
        this.stringBuilder = new StringBuilder();
    }
    
    public static ObjectToFile getInstance() {
        return objectToFile;
    }

    public String getWriteString() {
        this.stringBuilder.setLength(0);

        List<Student> studentList = this.studentRepository.findAll();
        List<Subject> subjectList = this.subjectRepository.findAll();

        appendFileFirstLine(subjectList);

        studentList.forEach(student -> {
            appendStudent(student);
            String requiredSubjectId = appendMajor(student.getMajorId());
            appendRequiredSubjectName(requiredSubjectId);
            appendScore(student.getId());

            this.stringBuilder.append("\n");
        });

        return this.stringBuilder.toString();
    }

    private void appendFileFirstLine(List<Subject> subjectList) {
        this.stringBuilder.append("이름 학번 전공 필수과목");
        subjectList.forEach(subject -> this.stringBuilder.append(" ").append(subject.getName() + "점수"));
        this.stringBuilder.append("\n");
    }

    private void appendStudent(Student student) {
        this.stringBuilder.append(student.getName());
        this.stringBuilder.append(" ")
                .append(student.getId());
    }

    private String appendMajor(String majorId) {
        Major major = majorRepository.findById(majorId);
        this.stringBuilder.append(" ")
                .append(major.getName());
        return major.getRequiredSubjectId();
    }

    private void appendRequiredSubjectName(String requiredSubjectId) {
        Subject findSubject = subjectRepository.findById(requiredSubjectId);
        this.stringBuilder.append(" ").append(findSubject.getName());
    }

    private void appendScore(String studentId) {
        List<Subject> subjectList = subjectRepository.findAll();

        subjectList.forEach(subject -> {
            Score findScore = scoreRepository.findById(studentId + subject.getId());
            String result = addScoreEmpty(findScore);
            this.stringBuilder.append(" ").append(result);
        });
    }

    private String addScoreEmpty(Score score) {
        if (score.isNotXScore()) {
            return score.getScore();
        }

        return " ";
    }
}
