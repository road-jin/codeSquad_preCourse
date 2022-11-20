package org.codesquad.domain;

import org.codesquad.support.AutoIDUtil;

import java.util.Objects;

public class Major {

    private final String id;
    private final String name;
    private final String requiredSubjectId;

    public Major(String name, String requiredSubjectId) {
        this.id = AutoIDUtil.createMajorId();
        this.name = name;
        this.requiredSubjectId = requiredSubjectId;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getRequiredSubjectId() {
        return requiredSubjectId;
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
        Major major = (Major) o;
        return Objects.equals(getId(), major.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
