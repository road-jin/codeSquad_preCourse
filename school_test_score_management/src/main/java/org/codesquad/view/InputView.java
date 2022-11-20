package org.codesquad.view;

import org.codesquad.domain.Major;
import org.codesquad.domain.Student;
import org.codesquad.domain.Subject;
import org.codesquad.service.dto.ScoreBySubjectRequest;
import org.codesquad.service.dto.StudentScoreRequest;
import org.codesquad.support.menu.Menu;

import java.util.*;

public class InputView {

    private static Scanner scanner = new Scanner(System.in);

    public static Menu selectMenu(Menu[] values) {
        for (int i = 0; i < values.length; i++) {
            int menuNumber = values[i].getMenuNumber();
            String title = values[i].getTitle();
            System.out.printf("[%s : %d] ", title, menuNumber);
        }

        System.out.print(" >> ");
        int menuNumber = scanner.nextInt();

        Optional<Menu> findMenu = Arrays.stream(values)
                .filter(v -> v.getMenuNumber() == menuNumber)
                .findFirst();

        if (findMenu.isEmpty()) {
            System.out.println("잘못된 메뉴 선택 입니다.\n");
            return selectMenu(values);
        }

        return findMenu.get();
    }

    public static String getStudentName() {
        System.out.print("이름을 입력해주세요 >> ");
        return scanner.next();
    }

    public static List<StudentScoreRequest> getStudentScoreList(String studentName, List<Subject> subjectList) {
        List<StudentScoreRequest> studentScoreRequestList = new ArrayList<>();

        subjectList.forEach(subject -> {
            String score = getScore(subject.getName(), studentName);
            studentScoreRequestList.add(new StudentScoreRequest(subject.getId(), score));
        });

        return studentScoreRequestList;
    }

    public static String getMajorId(List<Major> majorList) {
        for (int i = 0 ; i < majorList.size(); i++) {
            System.out.printf("[%s : %d] ", majorList.get(i).getName(), i + 1);
        }

        System.out.print("전공을 선택해주세요 >> ");
        int index = scanner.nextInt();

        if (index <= 0 || index > majorList.size()) {
            System.out.println("잘못된 전공 선택 입니다.\n");
            return getMajorId(majorList);
        }

        return majorList.get(index - 1).getId();
    }

    public static Subject getSubject(List<Subject> subjectList) {
        for (int i = 0; i < subjectList.size(); i++) {
            Subject subject = subjectList.get(i);
            System.out.printf("[%s : %d] ", subject.getName(), i + 1);
        }

        System.out.print("\n조회 하고 싶은 과목번호를 선택해주세요 >> ");
        int index = scanner.nextInt();

        if (index <= 0 || index > subjectList.size()) {
            System.out.println("잘못된  선택 입니다.\n");
            return getSubject(subjectList);
        }


        return subjectList.get(index - 1);
    }

    public static String getSubjectName() {
        System.out.print("과목명을 입력해주세요 >> ");
        return scanner.next();
    }

    public static List<ScoreBySubjectRequest> getScoreBySubjectList(String subjectName, List<Student> studentList) {
        List<ScoreBySubjectRequest> scoreBySubjectRequestList = new ArrayList<>();

        studentList.forEach(s -> {
            String score = getScore(subjectName, s.getName());
            scoreBySubjectRequestList.add(new ScoreBySubjectRequest(s.getId(), score));
        });

        return scoreBySubjectRequestList;
    }

    public static void close() {
        scanner.close();
    }

    private static String getScore(String subjectName, String studentName) {
        System.out.printf("%s의 %s 성적을 입력해주세요 (수강하지 않았으면 'X'를 입력해주세요) >> ", studentName, subjectName);

        String input = scanner.next().trim();

        if (input.equalsIgnoreCase("X")) {
            return input;
        }

        int number = 0;

        try {
            number = Integer.parseInt(input);

        } catch (NumberFormatException e) {
            System.out.println("잘못된 입력입니다.\n");
            return getScore(subjectName, studentName);
        }

        if (number < 0 || number > 100) {
            System.out.println("잘못된 입력입니다.\n");
            return getScore(subjectName, studentName);
        }

        return String.valueOf(number);
    }
}
