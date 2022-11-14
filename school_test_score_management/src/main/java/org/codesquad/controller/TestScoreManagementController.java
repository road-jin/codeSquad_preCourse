package org.codesquad.controller;

import org.codesquad.converter.ObjectToFile;
import org.codesquad.domain.Menu;
import org.codesquad.domain.Score;
import org.codesquad.domain.Student;
import org.codesquad.service.ScoreService;
import org.codesquad.service.StudentService;
import org.codesquad.service.SubjectService;
import org.codesquad.util.FileUtil;
import org.codesquad.view.InputView;
import org.codesquad.view.ResultView;

import java.util.List;

public class TestScoreManagementController {

    private final StudentService studentService;
    private final SubjectService subjectService;
    private final ScoreService scoreService;

    public TestScoreManagementController(StudentService studentService, SubjectService subjectService, ScoreService scoreService) {
        this.studentService = studentService;
        this.subjectService = subjectService;
        this.scoreService = scoreService;
    }

    public void run() {
        InputView.start();
        Menu menu = Menu.ETC;

        while(isExit(menu)) {
            menu = InputView.selectMenu();
            menu.execute(this);
        }
    }

    public void read() {
        ResultView.scoreView(studentService.findAll(), scoreService);
    }

    public void add() {
        String name = InputView.getStudentName();
        List<String> requiredSubjectIdList = InputView.getRequiredSubjectIdList(subjectService.findAll());
        Student saveStudent = studentService.save(name, requiredSubjectIdList);
        List<Score> scoreList = InputView.getSubjectScoreList(saveStudent.getId(), subjectService.findAll());
        scoreService.save(scoreList);
        FileUtil.write(ObjectToFile.getInstance().getWriteString());
    }

    public void edit() {
        ResultView.studentDetailView(studentService.findAll(), subjectService, scoreService);
        String studentId = InputView.getStudentId(studentService);
        List<Score> scoreList = InputView.getSubjectScoreList(studentId, subjectService.findAll());
        scoreService.update(scoreList);
        FileUtil.write(ObjectToFile.getInstance().getWriteString());
    }

    public void remove() {

    }

    private boolean isExit(Menu menu) {
        if (menu.equals(Menu.EXIT)) {
            InputView.close();
            return false;
        }

        return true;
    }
}
