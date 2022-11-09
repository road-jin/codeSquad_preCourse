package org.codesquad;

import java.time.LocalDate;

public class Question5 {

    public static void main(String[] args) {
        // https://school.programmers.co.kr/learn/courses/30/lessons/12901
        String[] weekDay = {"MON","TUE","WED","THU","FRI","SAT","SUN"};
        int value = LocalDate.of(2016, 1, 3)
                .getDayOfWeek()
                .getValue();

        String answer = weekDay[value-1];
    }
}
