package org.codesquad.person.marriageinfo;

public enum MaritalStatus {
    single( "미혼자"),
    married("기혼자");

    private String title;

    MaritalStatus(String title) {
        this.title = title;
    }

    public String getTitle() {
        return this.title;
    }
}