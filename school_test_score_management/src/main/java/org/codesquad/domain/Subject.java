package org.codesquad.domain;

import org.codesquad.support.AutoIDUtil;

import java.util.Objects;

public class Subject  {

    private final String id;
    private final String name;

    public Subject(String name) {
        this.id = AutoIDUtil.createSubjectId();
        this.name = name;
    }

    public Subject(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public boolean isEqualsId(String id) {
        return this.id.equals(id);
    }

    public boolean isEqualsName(String name) {
        return this.name.equals(name);
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Subject subject = (Subject) o;
        return getId().equals(subject.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
