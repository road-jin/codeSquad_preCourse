package org.codesquad;

import java.util.Arrays;

public class Question1 {

    public static void main(String[] args) {
        // https://school.programmers.co.kr/learn/courses/30/lessons/12910
        int[] arr = {3, 2, 1, 3};
        int divisor = 10;
        int[] answer = Arrays.stream(arr)
                .filter(number -> number % divisor == 0)
                .sorted()
                .toArray();

        if (answer.length == 0) {
            answer = new int[]{-1};
        }
    }
}
