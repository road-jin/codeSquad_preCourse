package org.codesquad;

import java.util.*;

public class Question3 {

    public static void main(String[] args) {
        // https://school.programmers.co.kr/learn/courses/30/lessons/68644
        int[] numbers = {2,1,3,4,1};
        Set<Integer> set = new TreeSet<>();

        for (int i = 0; i < numbers.length - 1; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                set.add(numbers[i] + numbers[j]);
            }
        }

        int[] answer = set.stream()
                .mapToInt(number -> (int) number)
                .toArray();
    }
}
