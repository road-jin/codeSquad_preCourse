package org.codesquad.service.dto;

import org.codesquad.support.AutoIDUtil;

import java.util.Objects;

public class SubjectRequest {

    private final String id;
    private final String name;

    public SubjectRequest(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
