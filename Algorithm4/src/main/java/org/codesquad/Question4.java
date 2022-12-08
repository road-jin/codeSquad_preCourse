package org.codesquad;

import java.util.Map;

public class Question4 {

    private static Map<Character, Integer> map;

    public static void main(String[] args) {
        String s = "III";
        init();
        romanToInt(s);
    }

    public static int romanToInt(String s) {
        int output = map.get(s.charAt(s.length() - 1));

        for (int i = s.length() - 2; i >= 0; i--) {
            if (map.get(s.charAt(i)) >= map.get(s.charAt(i + 1))) {
                output += map.get(s.charAt(i));
            } else {
                output -= map.get(s.charAt(i));
            }
        }

        return output;
    }

    public static void init() {
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
    }
}
