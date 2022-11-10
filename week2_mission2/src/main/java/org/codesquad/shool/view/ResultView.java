package org.codesquad.shool.view;

import org.codesquad.shool.FileSystem;
import org.codesquad.shool.student.Student;

import java.util.List;

public class ResultView {

    public static void startDisplay() {
        System.out.println("<<성적관리 시스템>>");
    }

    public static void gradeReadView() {
        List<Student> studentList = FileSystem.getStudentList();
        studentList.forEach(student -> System.out.println(student.info()));
    }

    public static void studentView() {
        System.out.println("이름\t학번\t전공과목\t국어\t수학\t영어");
        List<Student> studentList = FileSystem.getStudentList();
        studentList.forEach(stu -> {
            String result = stu.detailInfo();
            System.out.println(result);
        });
    }
}