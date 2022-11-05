package org.codesquad.person.personalidentification;

public enum Gender {
    male("남자"),
    female("여자");

    private String title;

    Gender(String title) {
        this.title = title;
    }

    public String getTitle() {
        return this.title;
    }
}
