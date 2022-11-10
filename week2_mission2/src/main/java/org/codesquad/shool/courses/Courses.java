package org.codesquad.shool.courses;

public class Courses {

    private final String name;
    private final int score;
    private final boolean requiredCourses;

    public Courses(String name, int score, boolean requiredCourses) {
        this.name = name;
        this.score = score;
        this.requiredCourses = requiredCourses;
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }

    public boolean isRequiredCourses() {
        return requiredCourses;
    }
}
