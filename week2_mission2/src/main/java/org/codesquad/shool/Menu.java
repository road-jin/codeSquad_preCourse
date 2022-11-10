package org.codesquad.shool;

import org.codesquad.shool.courses.CoursesList;
import org.codesquad.shool.student.Student;
import org.codesquad.shool.view.InputView;
import org.codesquad.shool.view.ResultView;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public enum Menu {
    read(1, Menu::read),
    add(2, Menu::add),
    edit(3, Menu::edit),
    exit(4, () -> {}),
    etc(5, () -> {});

    private int menuNumber;
    private Runnable runnable;

    Menu(int menuNumber, Runnable runnable) {
        this.menuNumber = menuNumber;
        this.runnable = runnable;
    }

    public int getMenuNumber() {
        return menuNumber;
    }

    public static Menu valueOf(int menuNumber) {
        return Arrays.stream(Menu.values())
                .filter(menu -> menu.getMenuNumber() == menuNumber)
                .findFirst()
                .orElse(Menu.etc);
    }

    public void execution() {
        runnable.run();
    }

    private static void read() {
        ResultView.gradeReadView();
    }

    private static void add() {
        String name = InputView.getStudentName();
        CoursesList coursesList = InputView.getCoursesList();
        Student student = new Student(name, coursesList);
        FileSystem.write(student);
    }

    private static void edit() {
        ResultView.studentView();

        Student findStudent = InputView.getStudentIdToStudent();
        CoursesList coursesList = InputView.getCoursesList();

        List<Student> studentList = FileSystem.getStudentList();
        studentList.remove(findStudent);
        studentList.add(findStudent.createStudent(coursesList));
        Collections.sort(studentList);

        FileSystem.remove();
        studentList.forEach(stu -> FileSystem.write(stu));
    }
}
