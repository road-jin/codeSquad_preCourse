package org.codesquad.member;

public enum Grade {

    SILVER("SILVER"),
    VIP("VIP"),
    PLATINUM("PLATINUM");

    private String title;

    Grade(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}

