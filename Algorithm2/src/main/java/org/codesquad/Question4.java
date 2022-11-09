package org.codesquad;

import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;

public class Question4 {
    static int[] user1 = {1,2,3,4,5};
    static int[] user2 = {2,1,2,3,2,4,2,5};
    static int[] user3 = {3,3,1,1,2,2,4,4,5,5};
    static int[] mathUsers = new int[3];

    public static void main(String[] args) {
        // https://school.programmers.co.kr/learn/courses/30/lessons/42840
        int[] answers = {1,3,2,4,2};
        Set<Integer> set = new TreeSet<>();

        marking(0, answers);

        int max = Arrays.stream(mathUsers).max().getAsInt();

        for (int i = 0; i < mathUsers.length; i++) {
            if (max == mathUsers[i]) {
                set.add(i+1);
            }
        }

        int[] answer = set.stream()
                .mapToInt(number -> (int)number)
                .toArray();
    }

    public static void marking(int index, int[] answers) {
        if (index >= answers.length) {
            return;
        }

        int result = answers[index];

        if (result == user1[index % 5]) {
            mathUsers[0]++;
        }

        if (result == user2[index % 8]) {
            mathUsers[1]++;
        }

        if (result == user3[index % 10]) {
            mathUsers[2]++;
        }

        marking(index + 1, answers);
    }
}
