package org.codesquad.domain;

import org.codesquad.support.AutoIDUtil;

import java.util.Objects;

public class Student {

    private final String id;
    private final String majorId;
    private final String name;

    public Student(String name, String majorId) {
        this.id = AutoIDUtil.createStudentId();
        this.name = name;
        this.majorId = majorId;
    }

    public Student(String id, String name, String majorId) {
        this.id = AutoIDUtil.createStudentId(id);
        this.name = name;
        this.majorId = majorId;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getMajorId() {
        return majorId;
    }

    public boolean isEqualsId(String id) {
        return this.id.equals(id);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return getId().equals(student.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
