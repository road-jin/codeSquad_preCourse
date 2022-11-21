package org.codesquad.set;

import org.codesquad.member.Grade;
import org.codesquad.member.Member;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

public class MemberShipManagementSet {

    private Set<Member> memberSet;

    public MemberShipManagementSet() {
        this.memberSet = new HashSet<>();
    }

    public void addMemberShip(int id, String name, Grade grade) {
        memberSet.add(new Member(id, name, grade));
    }

    public boolean removeMember(int id) {
        Optional<Member> findMember = findMember(id);

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

    private Optional<Member> findMember(int id) {
        return this.memberSet.stream()
                .filter(m -> m.isEqualsId(id))
                .findFirst();
    }
}
