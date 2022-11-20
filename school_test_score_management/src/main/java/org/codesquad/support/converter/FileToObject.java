package org.codesquad.support.converter;

import org.codesquad.domain.Major;
import org.codesquad.domain.Score;
import org.codesquad.domain.Student;
import org.codesquad.domain.Subject;
import org.codesquad.support.FileUtil;

import java.util.ArrayList;
import java.util.List;

public class FileToObject {

    private static final FileToObject FILE_TO_OBJECT = new FileToObject();

    private final List<Student> studentList;
    private final List<Subject> subjectList;
    private final List<Score> scoreList;
    private final List<Major> majorList;

    private FileToObject() {
        this.studentList = new ArrayList<>();
        this.subjectList = new ArrayList<>();
        this.scoreList = new ArrayList<>();
        this.majorList = new ArrayList<>();
        init();
    }

    public static FileToObject getInstance() {
        return FILE_TO_OBJECT;
    }

    public List<Student> getStudentList() {
        return studentList;
    }

    public List<Subject> getSubjectList() {
        return subjectList;
    }

    public List<Score> getScoreList() {
        return scoreList;
    }

    public List<Major> getMajorList() {
        return majorList;
    }

    private void init() {
        String readString = FileUtil.read()
                .replaceAll("  ", " X");

        addSubjectList(readString);

        for (String studentInfoList : getStudentInfoList(readString)) {
            String[] studentInfo = studentInfoList.split(" ");
            String majorId = addMajorList(studentInfo);
            addStudentList(studentInfo, majorId);
            addScoreList(studentInfo);
        }
    }

    private void addSubjectList(String readString) {
        String firstString = readString.split("\n")[0];
        List<String> fileList = new ArrayList<>(List.of(firstString.split(" ")));
        List<String> subjectList = fileList.subList(4, fileList.size());

        subjectList.forEach(subject -> {
            String subjectName = subject.replace("점수", "");
            this.subjectList.add(new Subject(subjectName));
        });
    }

    private List<String> getStudentInfoList(String readString) {
        List<String> studentInfoList = new ArrayList<>(List.of(readString.split("\n")));
        studentInfoList.remove(0);  //  과목 줄 제거
        return studentInfoList;
    }

    private String addMajorList(String[] studentInfo) {
        String majorName = studentInfo[2];
        String requiredSubjectName = studentInfo[3];
        String requiredSubjectId = getSubjectId(requiredSubjectName);

        Major major = majorList.stream()
                .filter(m -> m.isEqualsName(majorName))
                .findFirst()
                .orElse(new Major(majorName, requiredSubjectId));

        if (!majorList.contains(major)) {
            majorList.add(major);
        }

        return major.getId();
    }

    private void addStudentList(String[] studentInfo, String majorId) {
        String studentName = studentInfo[0];
        String studentId = studentInfo[1];
        this.studentList.add(new Student(studentId, studentName, majorId));
    }

    private void addScoreList(String[] studentInfo) {
        for (int i = 4; i < studentInfo.length; i++) {
            String score = studentInfo[i];
            Subject subject = subjectList.get(i - 4);
            scoreList.add(new Score(studentInfo[1], subject.getId(), score));
        }
    }


    private String getSubjectId(String findName) {
        return this.subjectList.stream()
                .filter(subject -> subject.isEqualsName(findName))
                .findFirst()
                .orElseThrow()
                .getId();
    }
}