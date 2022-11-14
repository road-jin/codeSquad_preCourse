package org.codesquad.domain;

import org.codesquad.util.AutoIDUtil;

import java.util.List;
import java.util.Objects;

public class Student {

    private final String id;
    private final String name;
    private final List<String> requiredSubjectIdList;

    public Student(String name, List<String> requiredSubjectIdList) {
        this.id = AutoIDUtil.createStudentId();
        this.name = name;
        this.requiredSubjectIdList = requiredSubjectIdList;
    }

    public Student(String id, String name, List<String> requiredSubjectIdList) {
        this.id = AutoIDUtil.createStudentId(id);
        this.name = name;
        this.requiredSubjectIdList = requiredSubjectIdList;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<String> getRequiredSubjectIdList() {
        return requiredSubjectIdList;
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
