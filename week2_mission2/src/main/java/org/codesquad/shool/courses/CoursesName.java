package org.codesquad.shool.courses;

public enum CoursesName {
    korean("국어"),
    math("수학"),
    english("영어");

    private String title;

    CoursesName(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}
