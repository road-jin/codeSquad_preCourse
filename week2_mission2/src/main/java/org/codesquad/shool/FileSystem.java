package org.codesquad.shool;

import org.codesquad.shool.student.Student;
import org.codesquad.shool.courses.Courses;
import org.codesquad.shool.courses.CoursesList;
import org.codesquad.shool.courses.CoursesName;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FileSystem {

    private static final String USER_PATH = System.getProperty("user.dir");
    private static final String PROJECT_PATH = "/week2_mission2/src/main/resources/input.txt";

    public static List<Student> getStudentList() {
        List<Student> studentList = new ArrayList<>();
        List<String> fileString = fileRead();

        for (int i = 1; i < fileString.size(); i++) {
            String[] info = fileString.get(i).split("\t");
            String name = info[0];
            int studentId = Integer.parseInt(info[1]);

            CoursesList coursesList = getCoursesList(info);
            studentList.add(new Student(studentId, name, coursesList));
        }

        return studentList;
    }

    public static void write(Student student) {
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(USER_PATH + PROJECT_PATH, true));
            bufferedWriter.write("\n" + student.detailInfo());
            bufferedWriter.flush();
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void cover(String writeString) {
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(USER_PATH + PROJECT_PATH));
            bufferedWriter.write(writeString);
            bufferedWriter.flush();
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void remove() {
        List<String> fileString = fileRead();
        cover(fileString.get(0));
    }

    private static ArrayList<String> fileRead() {
        StringBuilder stringBuilder = new StringBuilder();

        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(USER_PATH + PROJECT_PATH));
            String line = "";

            while ((line = bufferedReader.readLine()) != null) {
                stringBuilder.append(line + ":");
            }

            bufferedReader.close();
        } catch (IOException e) {
            System.out.println("파일이 없습니다.");
        }

        stringBuilder = new StringBuilder(stringBuilder.toString().replace("\t\t", "\t0\t"));

        return new ArrayList<>(Arrays.asList(stringBuilder.toString().split(":")));
    }

    private static CoursesList getCoursesList(String[] info) {
        ArrayList<Courses> coursesArr = new ArrayList<>();
        CoursesName[] values = CoursesName.values();
        String requiredCoursesName = info[2];

        for (int j = 3; j < info.length; j++) {
            int score = Integer.parseInt(info[j].trim());
            String coursesName = values[j - 3].getTitle();
            boolean requiredCourses = getRequiredCourses(requiredCoursesName, coursesName);
            coursesArr.add(new Courses(coursesName, score, requiredCourses));
        }

        return new CoursesList(coursesArr);
    }

    private static boolean getRequiredCourses(String requiredCoursesName, String coursesName) {
        boolean requiredCourses = false;

        if (requiredCoursesName.equals(coursesName)) {
            requiredCourses = true;
        }

        return requiredCourses;
    }
}
