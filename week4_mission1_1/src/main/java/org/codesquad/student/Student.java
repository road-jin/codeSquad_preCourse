package org.codesquad.student;

public class Student {

    private final String name;
    private final String subject;
    private final Integer id;
    private final Double gradeAverage;

    public Student(String name, String subject, Integer id, Double gradeAverage) {
        this.name = name;
        this.subject = subject;
        this.id = id;
        this.gradeAverage = gradeAverage;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSubject() {
        return subject;
    }

    public Double getGradeAverage() {
        return gradeAverage;
    }

    public boolean findByName(String name) {
        return this.name.equals(name);
    }
}
