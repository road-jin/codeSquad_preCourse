package org.codesquad.treeset;

import org.codesquad.member.Grade;
import org.codesquad.member.Member;

import java.util.Optional;
import java.util.Set;
import java.util.TreeSet;

public class MemberShipManagementTreeSet {

    private Set<Member> memberSet;

    public MemberShipManagementTreeSet() {
        this.memberSet = new TreeSet<>();
    }

    public void addMemberShip(int id, String name, Grade grade) {
        if (!memberSet.add(new Member(id, name, grade))) {
            System.out.printf("이미 있는 아이디 %d는 추가할 수 없습니다\n", id);
            //System.out.printf("이미 있는 이름 %s는 추가할 수 없습니다\n", name);
        }
    }

    public boolean removeMember(int id) {
        Optional<Member> findMember = findById(id);

        if (findMember.isEmpty()) {
            System.out.printf("%d에 해당하는 멤버가 없습니다.\n", id);
            return false;
        }

        this.memberSet.remove(findMember.get());
        return true;
    }

    public void showAllMember() {
        System.out.println("========================================");
        this.memberSet.forEach(m -> System.out.println(m.showInfo()));
        System.out.println("========================================");
    }

    private Optional<Member> findById(int id) {
        return this.memberSet.stream()
                .filter(m -> m.isEqualsId(id))
                .findFirst();
    }

    private Optional<Member> findByName(String name) {
        return this.memberSet.stream()
                .filter(m -> m.isEqualsName(name))
                .findFirst();
    }
}
