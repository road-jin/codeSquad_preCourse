package org.codesquad.shool.student;

import org.codesquad.shool.courses.CoursesList;

import java.util.Objects;

public class Student implements Comparable<Student>{

    private final int studentId;
    private final String name;
    private final CoursesList coursesList;

    public Student(String name, CoursesList coursesList) {
        this.studentId = AutoStudentId.getInstance().getStudentId();
        this.name = name;
        this.coursesList = coursesList;
    }

    public Student(int studentId, String name, CoursesList coursesList) {
        this.studentId = studentId;
        this.name = name;
        this.coursesList = coursesList;
    }

    public boolean isStudentId(int studentId) {
        if (this.studentId == studentId) {
            return true;
        }

        return false;
    }

    public String detailInfo() {
        return name + "\t" + studentId + "\t" + coursesList.infoFileWriteConverter();
    }

    public String[] info() {
        return new String[] {name, String.valueOf(coursesList.size()),
                String.valueOf(coursesList.totalScore()),
                String.valueOf(coursesList.averageScore())};
    }

    public Student createStudent(CoursesList coursesList) {
        return new Student(studentId, name, coursesList);
    }

    @Override
    public int compareTo(Student o) {
        if (studentId > o.studentId) {
            return 1;
        }

        if (studentId < o.studentId) {
            return -1;
        }

        return 0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return studentId == student.studentId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(studentId);
    }
}
