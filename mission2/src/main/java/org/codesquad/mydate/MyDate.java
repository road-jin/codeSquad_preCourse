package org.codesquad.mydate;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.Arrays;

public class MyDate {
    private final Integer year;
    private final Integer month;
    private final Integer day;

    public MyDate(int day, int month, int year) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public String isValid() {
        try {
            LocalDate.of(year, month, day);
        } catch (DateTimeException e) {
            return year + "년 " + month + "월 " + day + "일은 유효하지 않은 날짜입니다.";
        }

        return year + "년 " + month + "월 " + day + "일은 유효한 날짜입니다.";
    }

    public String isValid2() {
        String trueResult = year + "년 " + month + "월 " + day + "일은 유효한 날짜입니다.";

        if (Arrays.asList(4, 6, 9, 11).contains(month) &&
                isDayBetween(1, 30)) {
            return trueResult;
        }

        if (Arrays.asList(1, 3, 5, 7, 8, 10, 12).contains(month) &&
                isDayBetween(1, 31)) {
            return trueResult;
        }

        if (month == 2 && day == 29 && isLeapYear()) {
            return trueResult;
        }

        return year + "년 " + month + "월 " + day + "일은 유효하지 않은 날짜입니다.";
    }

    private boolean isLeapYear() {
        if (year % 4 == 0 &&
                (year % 100 != 0 || year % 400 == 0)) {
            return true;
        }

        return false;
    }

    private boolean isDayBetween(int minNumber, int maxNumber) {
        if (day >= maxNumber && day <= maxNumber) {
            return true;
        }

        return false;
    }
}
