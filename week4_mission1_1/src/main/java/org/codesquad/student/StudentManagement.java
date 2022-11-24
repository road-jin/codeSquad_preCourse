package org.codesquad.student;

import java.util.Optional;
import java.util.Scanner;

public class StudentManagement {

    private final Scanner scanner;
    private final Students students;

    public StudentManagement() {
        this.scanner = new Scanner(System.in);
        this.students = new Students();
    }

    public void run() {
        addStudent();
        searchStudent();
    }

    private void addStudent() {
        System.out.println("학생 이름, 학과, 학번, 학점평균 입력하세요.");

        for (int i = 0; i < 4; i++) {
            System.out.print(">> ");
            students.add(getStudent());
        }
    }

    private Student getStudent() {
        String name = scanner.next().replace(",", "");
        String subject = scanner.next().replace(",", "");
        Integer id = Integer.parseInt(scanner.next().replace(",", ""));
        return new Student(name, subject, id, scanner.nextDouble());
    }

    public void searchStudent() {
        String name = "";

        while (isExit(name)) {
            System.out.print("학생 이름 >> ");
            name = scanner.next();
            printFoundStudent(name);
        }
    }

    private void printFoundStudent(String name) {
        if (!isExit(name)) {
            return;
        }

        Optional<Student> findStudent = students.findByName(name);

        if (findStudent.isPresent()) {
            Student student = findStudent.get();
            System.out.printf("%s, %s, %d, %f\n\n", student.getName(), student.getSubject(), student.getId(), student.getGradeAverage());
            return;
        }

        System.out.print("찾으시는 학생이 없습니다.\n");
    }

    private boolean isExit(String name) {
        return !name.equals("그만");
    }
}
