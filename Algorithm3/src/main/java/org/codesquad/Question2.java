package org.codesquad;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class Question2 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int gradesCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> grades = IntStream.range(0, gradesCount).mapToObj(i -> {
                    try {
                        return bufferedReader.readLine().replaceAll("\\s+$", "");
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                })
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(toList());

        List<Integer> result = gradingStudents(grades);

        result.forEach(System.out::println);
        /*bufferedWriter.write(
                result.stream()
                        .map(Object::toString)
                        .collect(joining("\n"))
                        + "\n"
        );*/

        bufferedReader.close();
        //bufferedWriter.close();
    }

    public static List<Integer> gradingStudents(List<Integer> grades) {
        // Write your code here
        List<Integer> results = grades.stream()
                .map(grade -> changeFinalGrade(grade))
                .collect(toList());

        return results;
    }

    public static Integer changeFinalGrade(Integer grade) {
        if (grade < 38) {
            return grade;
        }

        if (grade % 5 > 2) {
            return grade + (5 - grade % 5);
        }

        return grade;
    }
}
