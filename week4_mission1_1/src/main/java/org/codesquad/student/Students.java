package org.codesquad.student;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Students {

    private final List<Student> studentList;

    public Students() {
        this.studentList = new ArrayList<>();
    }

    public void add(Student student) {
        studentList.add(student);
    }

    public void printAll() {
        System.out.println("----------------------------------\n");
        studentList.forEach(s -> {
            System.out.printf("이름 : %s\n", s.getName());
            System.out.printf("학과 : %s\n", s.getSubject());
            System.out.printf("학번 : %d\n", s.getId());
            System.out.printf("학정평균 : %f\n", s.getGradeAverage());
            System.out.println("\n----------------------------------\n");
        });
    }

    public Optional<Student> findByName(String name) {
        return studentList.stream()
                .filter(student -> student.findByName(name))
                .findFirst();
    }
}
