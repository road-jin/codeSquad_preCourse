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
        if (findMember(id).isPresent()) {
            System.out.printf("이미 있는 아이디 %d는 추가할 수 없습니다\n", id);
            return;
        }

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
        /*
        Iterator<Member> iterator = memberSet.iterator();

        while (iterator.hasNext()) {
            Member member = iterator.next();
            System.out.println(member.showInfo());
        }

        for (Member member : memberSet) {
            System.out.println(member.showInfo());
        }
        */
    }

    private Optional<Member> findMember(int id) {
        return this.memberSet.stream()
                .filter(m -> m.isEqualsId(id))
                .findFirst();
    }
}
