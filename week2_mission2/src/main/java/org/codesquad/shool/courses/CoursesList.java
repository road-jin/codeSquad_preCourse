package org.codesquad.shool.courses;

import java.util.List;

public class CoursesList {

    private final List<Courses> coursesList;

    public CoursesList(List<Courses> coursesList) {
        this.coursesList = coursesList;
    }

    public int size() {
        return coursesList.size();
    }

    public int totalScore() {
        int totalScore = 0;

        for (Courses courses : coursesList) {
            totalScore += courses.getScore();
        }

        return totalScore;
    }

    public double averageScore() {
        int totalScore = totalScore();
        return totalScore / (double) coursesList.size();
    }

    public String infoFileWriteConverter() {
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < coursesList.size(); i++) {
            putRequiredCourses(stringBuilder, i);
            int score = coursesList.get(i).getScore();
            stringBuilder.append("\t" + validateScore(score));
        }

        return stringBuilder.toString();
    }

    private String validateScore(int score) {
        String result = String.valueOf(score);

        if (score == 0) {
            result = "";
        }
        return result;
    }

    private void putRequiredCourses(StringBuilder stringBuilder, int i) {
        if (coursesList.get(i).isRequiredCourses()) {
            stringBuilder.insert(0,coursesList.get(i).getName());
        }
    }
}
