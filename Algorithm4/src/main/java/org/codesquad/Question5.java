package org.codesquad;

public class Question5 {

    public static void main(String[] args) {
        String[] strs = {"dog", "racecar", "car"};
        longestCommonPrefix(strs);
    }

    public static String longestCommonPrefix(String[] strs) {
        String result = strs[0];

        for (int i = 1; i < strs.length; i++) {
            while (strs[i].indexOf(result) != 0) {
                result = result.substring(0, result.length() - 1);
            }
        }

        return result;
    }
}
