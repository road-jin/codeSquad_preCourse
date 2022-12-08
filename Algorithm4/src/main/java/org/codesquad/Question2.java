package org.codesquad;

public class Question2 {

    public static void main(String[] args) {
        int x = 123;
        reverse(x);
    }

    public static int reverse(int x) {
        long result = 0;

        while (x != 0) {
            result =  result * 10 + (x % 10);
            x = x / 10;
        }

        if (Integer.MIN_VALUE < result && result < Integer.MAX_VALUE) {
            return (int) result;
        }

        return 0;
    }
}
