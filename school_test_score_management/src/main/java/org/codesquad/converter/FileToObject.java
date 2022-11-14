package org.codesquad.converter;

import org.codesquad.domain.Score;
import org.codesquad.domain.Student;
import org.codesquad.domain.Subject;
import org.codesquad.util.FileUtil;

import java.util.ArrayList;
import java.util.List;

public class FileToObject {

    private static final FileToObject FILE_TO_OBJECT = new FileToObject();

    private final List<Student> studentList;
    private final List<Subject> subjectList;
    private final List<Score> scoreList;

    private FileToObject() {
        this.studentList = new ArrayList<>();
        this.subjectList = new ArrayList<>();
        this.scoreList = new ArrayList<>();
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

    private void init() {
        String readString = FileUtil.read()
                .replaceAll("  ", " X");

        // 과목 추가
        addSubjectList(readString);

        // 학번 추가
        List<String> stringList = new ArrayList<>(List.of(readString.split("\n")));
        stringList.remove(0);

        for (String s : stringList) {
            String[] split = s.split(" ");
            String studentName = split[0];
            String studentId = split[1];
            List<String> requiredSubjectIdList = new ArrayList<>();
            addRequiredSubjectAndScoreList(split, requiredSubjectIdList, 2, 0);
            this.studentList.add(new Student(studentId, studentName, requiredSubjectIdList));
        }
    }

    private void addRequiredSubjectAndScoreList(String[] split, List<String> requiredSubjectIdList, int index, int subjectCount) {
        if (index > split.length -1) {
            return;
        }

        if (isSubjectNameCheck(split[index])) {
            String subjectName = split[index];
            Subject findSubject = this.subjectList.stream()
                    .filter(subject -> subject.getName().equals(subjectName))
                    .findFirst()
                    .orElseThrow();

            requiredSubjectIdList.add(findSubject.getId());
            addRequiredSubjectAndScoreList(split, requiredSubjectIdList, ++index, subjectCount);
            return;
        }

        String studentId = split[1];

        // 점수 추가
        Subject subject = this.subjectList.get(subjectCount);
        this.scoreList.add(new Score(studentId, subject.getId(), split[index]));
        addRequiredSubjectAndScoreList(split, requiredSubjectIdList, ++index, ++subjectCount);
    }

    private void addSubjectList(String readString) {
        String firstString = readString.split("\n")[0];
        List<String> stringList = new ArrayList<>(List.of(firstString.split(" ")));
        stringList.remove(0);
        stringList.remove(0);
        stringList.remove(0);

        stringList.forEach(subject -> this.subjectList.add(new Subject(subject)));
    }

    private boolean isSubjectNameCheck(String subjectName) {
        return this.subjectList.stream()
                .anyMatch(subject -> subject.getName().equals(subjectName));
    }
}