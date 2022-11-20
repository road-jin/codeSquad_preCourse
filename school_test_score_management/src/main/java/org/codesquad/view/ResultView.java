package org.codesquad.view;

import org.codesquad.service.dto.ReportResponse;

import java.util.List;

public class ResultView {

    public static void start() {
        System.out.println("=================================");
        System.out.println("=         성적 관리 프로그램         =");
        System.out.println("=================================\n");
    }

    public static void reportView(List<ReportResponse> reportResponseList) {
        System.out.println("---------------------------------------");
        System.out.printf("          %s 수강생 학점\n", reportResponseList.get(0).getSubjectName());
        System.out.printf("이름 |   학번   | 중점과목 | 점수\n");
        System.out.println("---------------------------------------");

        reportResponseList.stream()
                .forEach(reportResponse -> {
                    System.out.printf("%s | %s | %-4s | %s:%s\n", reportResponse.getStudentName(), reportResponse.getStudentId(),
                            reportResponse.getRequiredSubjectName(), reportResponse.getScore(), reportResponse.getGrade());
                    System.out.println("---------------------------------------");
                });

        System.out.println();
    }
}
