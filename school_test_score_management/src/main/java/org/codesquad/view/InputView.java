package org.codesquad.view;

import org.codesquad.domain.Menu;
import org.codesquad.domain.Score;
import org.codesquad.domain.Subject;
import org.codesquad.service.StudentService;

import java.util.*;

public class InputView {

    private static Scanner scanner = new Scanner(System.in);

    public static void start() {
        System.out.println("=================================");
        System.out.println("=         성적 관리 프로그램         =");
        System.out.println("=================================\n");
    }


    public static Menu selectMenu() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("\n");
        Menu[] values = Menu.values();

        for (int i = 0; i < values.length - 1; i++) {
            int menuNumber = values[i].getMenuNumber();
            String title = values[i].getTitle();

            stringBuilder.append(title)
                    .append(":")
                    .append(menuNumber)
                    .append(" ");
        }

        stringBuilder.append(">> ");
        System.out.print(stringBuilder);

        Menu menu = Menu.valueOf(scanner.nextInt());

        if (menu.equals(Menu.ETC)) {
            System.out.println("잘못된 메뉴 선택 입니다.\n");
            return selectMenu();
        }

        return menu;
    }

    public static String getStudentName() {
        System.out.print("이름을 입력해주세요 >> ");
        return scanner.next();
    }

    public static List<String> getRequiredSubjectIdList(List<Subject> subjectList) {
        List<String> list = new ArrayList<>();

        System.out.print("과목 종류 : ");
        subjectList.forEach(subject -> System.out.printf("%s ", subject.getName()));
        System.out.print("\n전공과목을 입력해주세요 (',' 구분표시 해주세요) >> ");

        String[] requiredSubjectIdList = scanner.next().split(",");
        Arrays.stream(requiredSubjectIdList)
                .forEach(requiredSubjectId -> {
                    String subjectId = subjectList.stream()
                            .filter(subject -> subject.isEqualsName(requiredSubjectId))
                            .findFirst()
                            .orElseThrow()
                            .getId();
                    list.add(subjectId);
                });

        list.sort(String::compareTo);
        return list;
    }

    public static List<Score> getSubjectScoreList(String studentId, List<Subject> subjectList) {
        List<Score> scoreList = new ArrayList<>();

        subjectList.forEach(subject -> {
            System.out.printf("%s 성적을 입력해주세요 (수강하지 않았으면 'X'를 입력해주세요) >> ", subject.getName());
            String score = scanner.next();
            scoreList.add(new Score(studentId, subject.getId(), score));
        });

        return scoreList;
    }

    public static String getStudentId(StudentService studentService) {
        System.out.printf("수정할 학번을 선택해주세요 >> ");
        String studentId = scanner.next();

        try {
            studentService.findById(studentId);
        }catch (NoSuchElementException e) {
            System.out.println("입력하신 학번의 학생이 없습니다.\n");
            return getStudentId(studentService);
        }
        return studentId;
    }

    public static void close() {
        scanner.close();
    }
}
