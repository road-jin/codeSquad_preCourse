package org.codesquad.shool.view;

import org.codesquad.shool.FileSystem;
import org.codesquad.shool.Menu;
import org.codesquad.shool.courses.Courses;
import org.codesquad.shool.courses.CoursesList;
import org.codesquad.shool.courses.CoursesName;
import org.codesquad.shool.student.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class InputView {

    private static final Scanner scanner = new Scanner(System.in);

    public static Menu selectMenu() {
        System.out.print("\n성적조회:1, 학생추가:2, 성적편집:3, 종료:4 >> ");
        Menu menu = Menu.valueOf(scanner.nextInt());

        if (menu.equals(Menu.etc)) {
            System.out.println("잘못된 메뉴 선택 입니다.\n");
            return selectMenu();
        }

        return menu;
    }

    public static String getStudentName() {
        System.out.print("이름을 입력해주세요 >> ");
        return scanner.next();
    }

    public static CoursesList getCoursesList() {
        ArrayList<Courses> coursesArr = new ArrayList<>();
        CoursesName[] coursesNames = CoursesName.values();

        for (int i = 0; i < CoursesName.values().length; i++) {
            int score = getScore(coursesNames[i]);
            boolean requiredCourses = isSkipRequiredCourses(score);
            String name = coursesNames[i].getTitle();
            coursesArr.add(new Courses(name, score, requiredCourses));
        }

        return new CoursesList(coursesArr);
    }

    public static Student getStudentIdToStudent() {
        System.out.printf("학번을 입력해주세요 >> ");
        int studentId = scanner.nextInt();
        List<Student> studentList = FileSystem.getStudentList();
        Optional<Student> findStudent = studentList.stream()
                .filter(student -> student.isStudentId(studentId))
                .findFirst();

        if (findStudent.isEmpty()) {
            return getStudentIdToStudent();
        }

        return findStudent.get();
    }

    public static void close() {
        scanner.close();
    }

    private static boolean isSkipRequiredCourses(int score) {
        boolean requiredCourses = false;

        if (score != 0) {
            requiredCourses = isRequiredCourses();
        }

        return requiredCourses;
    }

    private static boolean isRequiredCourses() {
        System.out.print("필수 과목 인가요 (true, false) >> ");
        return Boolean.valueOf(scanner.next());
    }

    private static int getScore(CoursesName coursesName) {
        System.out.printf("%s 성적을 입력해주세요 >> ", coursesName);
        int score = scanner.nextInt();

        if (score < 0 || score > 100) {
            System.out.println("성적은 0이상 100점이하여야 합니다.");
            return getScore(coursesName);
        }
        return score;
    }
}
