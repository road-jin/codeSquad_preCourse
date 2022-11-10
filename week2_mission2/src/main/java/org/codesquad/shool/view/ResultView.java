package org.codesquad.shool.view;

import org.codesquad.shool.FileSystem;
import org.codesquad.shool.student.Student;

import java.text.DecimalFormat;
import java.util.List;

public class ResultView {

    public static void startDisplay() {
        System.out.println("<<성적관리 시스템>>");
    }

    public static void gradeReadView() {
        List<Student> studentList = FileSystem.getStudentList();
        studentList.forEach(student -> {
            String[] info = student.info();
            DecimalFormat zeroRemove = new DecimalFormat("#.##");
            String average = zeroRemove.format(Double.valueOf(info[3]));

            System.out.printf("%s 학생은 %d과목을 수강했습니다.\n", info[0], Integer.parseInt(info[1]));
            System.out.printf("총점은 %d점이고 평균은 %s점입니다.\n", Integer.parseInt(info[2]), average);
        });
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