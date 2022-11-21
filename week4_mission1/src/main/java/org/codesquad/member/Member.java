package org.codesquad.member;

import java.util.Comparator;
import java.util.Objects;

public class Member implements Comparable<Member>, Comparator<Member> {

    private int id;
    private String name;
    private Grade grade;

    public Member(int id, String name, Grade grade) {
        this.id = id;
        this.name = name;
        this.grade = grade;
    }

    public String showInfo() {
        return this.name + "님의 아이디는 " + this.id + "이고 등급은 " + this.grade.getTitle() + "입니다.";
    }

    public boolean isEqualsId(int id) {
        return this.id == id;
    }

    public boolean isEqualsName(String name) {
        return this.name.equalsIgnoreCase(name);
    }

    @Override
    public boolean equals(Object o) {
        Member member = (Member) o;
        return this.id == member.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public int compareTo(Member o) {
        return this.id - o.id;
    }

    @Override
    public int compare(Member o1, Member o2) {
        return o1.id - o2.id;
    }

/*    @Override
    public int compareTo(Member o) {
        return this.name.compareTo(o.name);
    }

    @Override
    public int compare(Member o1, Member o2) {
        return o1.name.compareTo(o2.name);
    }*/
}
