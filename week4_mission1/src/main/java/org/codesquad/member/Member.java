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

        if (this.id == member.id) {
            System.out.printf("이미 있는 아이디 %d는 추가할 수 없습니다\n", this.id);
            return true;
        }

        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public int compareTo(Member o) {
        int number = this.id - o.id;

        if (number == 0) {
            System.out.printf("이미 있는 아이디 %d는 추가할 수 없습니다\n", this.id);
        }

        return number;
    }

    @Override
    public int compare(Member o1, Member o2) {
        int number = o1.id - o2.id;

        if (number == 0) {
            System.out.printf("이미 있는 아이디 %d는 추가할 수 없습니다\n", this.id);
        }

        return number;
    }

/*    @Override
    public int compareTo(Member o) {
        int number = this.name.compareTo(o.name);

        if (number == 0) {
            System.out.printf("이미 있는 이름 %s는 추가할 수 없습니다\n", this.name);
        }

        return number;
    }

    @Override
    public int compare(Member o1, Member o2) {
        int number = o1.name.compareTo(o2.name);

        if (number == 0) {
            System.out.printf("이미 있는 이름 %s는 추가할 수 없습니다\n", this.name);
        }

        return number;
    }*/
}
