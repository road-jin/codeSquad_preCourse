package org.codesquad.list;

import org.codesquad.member.Grade;
import org.codesquad.member.Member;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class MemberShipManagementList {

    private List<Member> memberList;

    public MemberShipManagementList() {
        this.memberList = new ArrayList<>();
    }

    public void addMemberShip(int id, String name, Grade grade) {
        this.memberList.add(new Member(id, name, grade));
    }

    public boolean removeMember(int id) {
        Optional<Member> findMember = this.memberList.stream()
                .filter(m -> m.isEqualsId(id))
                .findFirst();

        if (findMember.isEmpty()) {
            System.out.printf("%d에 해당하는 멤버가 없습니다.\n", id);
            return false;
        }

        this.memberList.remove(findMember.get());
        return true;
    }

    public void showAllMember() {
        System.out.println("========================================");
        this.memberList.forEach(m -> System.out.println(m.showInfo()));
        System.out.println("========================================");
    }
}
