package org.codesquad;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;


public class Question5 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = bufferedReader.readLine();

        String result = timeConversion(s);

        System.out.println(result);

        //bufferedWriter.write(result);
        //bufferedWriter.newLine();

        bufferedReader.close();
        //bufferedWriter.close();
    }

    public static String timeConversion(String s) {
        // Write your code here
        String[] time = s.substring(0, s.length() - 2).split(":");
        Integer hour = Integer.parseInt(time[0]);
        String minute = time[1];
        String second = time[2];
        String formatAmPm = s.substring(s.length() - 2);

        if (formatAmPm.equals("PM")) {
            return pmTimeFormat(hour, minute, second);
        }

        if (formatAmPm.equals("AM")) {
            return amTimeFormat(hour, minute, second);
        }

        return null;
    }

    private static String amTimeFormat(Integer hour, String minute, String second) {
        if (hour != 12) {
            return String.format("%02d", hour) + ":" + minute + ":" + second;
        }

        return String.format("%02d", 0) + ":" + minute + ":" + second;
    }

    private static String pmTimeFormat(Integer hour, String minute, String second) {
        if (hour != 12) {
            return (hour + 12) + ":" + minute + ":" + second;
        }

        return String.format("%02d", hour) + ":" + minute + ":" + second;
    }
}