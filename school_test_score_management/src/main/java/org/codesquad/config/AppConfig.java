package org.codesquad.config;

import org.codesquad.controller.TestScoreManagementController;
import org.codesquad.repository.*;
import org.codesquad.service.ScoreService;
import org.codesquad.service.StudentService;
import org.codesquad.service.SubjectService;

public class AppConfig {

    private static final AppConfig appConfig = new AppConfig();

    private AppConfig() {

    }

    public static AppConfig getInstance() {
        return appConfig;
    }

    public TestScoreManagementController getTestScoreManagementController() {
        return new TestScoreManagementController(getStudentService(),
                getSubjectService(), getScoreService());
    }

    public StudentService getStudentService() {
        return new StudentService(getStudentRepository());
    }

    public SubjectService getSubjectService() {
        return new SubjectService(getSubjectRepository());
    }

    public ScoreService getScoreService() {
        return new ScoreService(getScoreRepository());
    }

    public StudentRepository getStudentRepository() {
        return new FileStudentRepository();
    }

    public SubjectRepository getSubjectRepository() {
        return new FileSubjectRepository();
    }

    public ScoreRepository getScoreRepository() {
        return new FileScoreRepository();
    }
}
