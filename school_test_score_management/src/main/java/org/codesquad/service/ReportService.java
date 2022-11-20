package org.codesquad.service;

import org.codesquad.domain.Major;
import org.codesquad.domain.Score;
import org.codesquad.domain.Student;
import org.codesquad.domain.Subject;
import org.codesquad.service.dto.ReportResponse;
import org.codesquad.repository.MajorRepository;
import org.codesquad.repository.ScoreRepository;
import org.codesquad.repository.StudentRepository;
import org.codesquad.repository.SubjectRepository;
import org.codesquad.support.grade.GradeEvaluation;
import org.codesquad.support.grade.GradeEvaluations;

import java.util.ArrayList;
import java.util.List;

public class ReportService {

    private final StudentRepository studentRepository;
    private final SubjectRepository subjectRepository;
    private final ScoreRepository scoreRepository;
    private final MajorRepository majorRepository;

    public ReportService(StudentRepository studentRepository, SubjectRepository subjectRepository, ScoreRepository scoreRepository, MajorRepository majorRepository) {
        this.studentRepository = studentRepository;
        this.subjectRepository = subjectRepository;
        this.scoreRepository = scoreRepository;
        this.majorRepository = majorRepository;
    }

    public List<ReportResponse> findAllBySubjectId(Subject subject) {
        List<ReportResponse> reportResponseList = new ArrayList<>();

        studentRepository.findAll()
                .stream()
                .forEach(student -> addReportResponseList(subject, reportResponseList, student));

        return reportResponseList;
    }

    private void addReportResponseList(Subject subject, List<ReportResponse> reportResponseList, Student student) {
        Score score = scoreRepository.findById(student.getId() + subject.getId());

        if (!score.isNotXScore()) {
            return;
        }

        Major major = majorRepository.findById(student.getMajorId());
        Subject RequiredSubject = subjectRepository.findById(major.getRequiredSubjectId());
        GradeEvaluation gradeEvaluation = GradeEvaluations.getInstance(major, subject);

        reportResponseList.add(new ReportResponse(student.getId(), student.getName(), RequiredSubject.getName(),
                score.getScore(), gradeEvaluation.getGrade(score.getScore()), subject.getName()));
    }
}
