package org.codesquad;

public class Question3 {

    public static void main(String[] args) {
        int x = 123;
        isPalindrome(x);
    }

    public static boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }

        String result = String.valueOf(Math.abs(x));

        for (int i = 0; i < result.length() / 2; i++) {
            if (result.charAt(i) != result.charAt(result.length() - 1 - i)) {
                return false;
            }
        }

        return true;
    }
}
