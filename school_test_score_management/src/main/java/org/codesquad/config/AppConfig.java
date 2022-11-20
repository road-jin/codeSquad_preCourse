package org.codesquad.config;

import org.codesquad.controller.MenuController;
import org.codesquad.repository.*;
import org.codesquad.service.*;

public class AppConfig {

    private static final AppConfig appConfig = new AppConfig();

    private AppConfig() {

    }

    public static AppConfig getInstance() {
        return appConfig;
    }

    public MenuController getMenuController() {
        return new MenuController(getStudentService(), getSubjectService(),
                getMajorService(), getReportService());
    }

    public ReportService getReportService() {
        return new ReportService(getStudentRepository(), getSubjectRepository(),
                getScoreRepository(), getMajorRepository());
    }

    public StudentService getStudentService() {
        return new StudentService(getStudentRepository(), getScoreRepository());
    }

    public SubjectService getSubjectService() {
        return new SubjectService(getSubjectRepository(), getScoreRepository());
    }

    public MajorService getMajorService() {
        return new MajorService(getMajorRepository());
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

    public MajorRepository getMajorRepository() {
        return new FileMajorRepository();
    }
}
