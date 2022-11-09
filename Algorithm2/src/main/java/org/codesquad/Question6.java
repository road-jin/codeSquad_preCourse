package org.codesquad;

public class Question6 {

    public static void main(String[] args) {
        // https://school.programmers.co.kr/learn/courses/30/lessons/12928
        int n = 5;
        int answer = 0;

        for (int i = 1; i <= n; i++) {
            if (n % i == 0) {
                answer += i;
            }
        }
    }
}
