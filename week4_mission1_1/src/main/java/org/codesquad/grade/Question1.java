package org.codesquad.grade;

import java.util.ArrayList;
import java.util.Scanner;

public class Question1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Double> gradeList = new ArrayList<>();

        System.out.print("6개의 학점을 빈 칸으로 분리 입력(A/B/C/D/F) >> ");

        for (int i = 0; i < 6; i++) {
            GradeConverter grade = GradeConverter.findByGrade(scanner.next());
            gradeList.add(grade.getScore());
        }

        double average = gradeList.stream()
                .mapToDouble(g -> g)
                .average()
                .orElseThrow();

        System.out.printf("\n%f\n", average);
        scanner.close();
    }
}
