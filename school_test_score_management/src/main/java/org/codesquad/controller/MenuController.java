package org.codesquad.controller;

import org.codesquad.domain.Subject;
import org.codesquad.service.MajorService;
import org.codesquad.service.ReportService;
import org.codesquad.service.StudentService;
import org.codesquad.service.SubjectService;
import org.codesquad.service.dto.ReportResponse;
import org.codesquad.service.dto.ScoreBySubjectRequest;
import org.codesquad.service.dto.StudentScoreRequest;
import org.codesquad.support.FileUtil;
import org.codesquad.support.converter.ObjectToFile;
import org.codesquad.support.menu.AddMenu;
import org.codesquad.support.menu.MainMenu;
import org.codesquad.support.menu.Menu;
import org.codesquad.view.InputView;
import org.codesquad.view.ResultView;

import java.util.List;

public class MenuController {

    private final StudentService studentService;
    private final SubjectService subjectService;
    private final MajorService majorService;
    private final ReportService reportService;

    public MenuController(StudentService studentService, SubjectService subjectService,
                          MajorService majorService, ReportService reportService) {
        this.studentService = studentService;
        this.subjectService = subjectService;
        this.majorService = majorService;
        this.reportService = reportService;
    }

    public void run() {
        ResultView.start();
        Menu mainMenu = MainMenu.READ;

        while(isExit(mainMenu)) {
            mainMenu = InputView.selectMenu(MainMenu.values());
            mainMenu.execute();
        }
    }

    public void read() {
        Subject subject = InputView.getSubject(subjectService.findAll());
        List<ReportResponse> reportResponseList = reportService.findAllBySubjectId(subject);
        ResultView.reportView(reportResponseList);
    }

    public void add() {
        Menu addMenu = InputView.selectMenu(AddMenu.values());
        addMenu.execute();
    }

    public void addStudent() {
        String studentName = InputView.getStudentName();
        String majorId = InputView.getMajorId(majorService.findAll());
        List<StudentScoreRequest> studentScoreRequestList = InputView.getStudentScoreList(studentName, subjectService.findAll());
        studentService.save(studentName, majorId, studentScoreRequestList);

        FileUtil.write(ObjectToFile.getInstance().getWriteString());
    }

    public void addSubject() {
        String subjectName = InputView.getSubjectName();
        List<ScoreBySubjectRequest> scoreBySubjectRequestList = InputView.getScoreBySubjectList(subjectName, studentService.findAll());
        subjectService.save(subjectName, scoreBySubjectRequestList);

        FileUtil.write(ObjectToFile.getInstance().getWriteString());
    }

    private boolean isExit(Menu mainMenu) {
        if (mainMenu.equals(MainMenu.EXIT)) {
            InputView.close();
            return false;
        }

        return true;
    }
}
