package org.codesquad.map;

import org.codesquad.member.Grade;
import org.codesquad.member.Member;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class MemberShipManagementMap {

    private final Map<Integer, Member> memberMap;

    public MemberShipManagementMap() {
        this.memberMap = new HashMap<>();
    }

    public void addMemberShip(int id, String name, Grade grade) {
        if (this.memberMap.containsKey(id)) {
            System.out.printf("이미 있는 아이디 %d의 값이 변경됩니다.\n", id);
        }

        this.memberMap.put(id, new Member(id, name, grade));
    }

    public boolean removeMember(int id) {
        if (!this.memberMap.containsKey(id)) {
            System.out.printf("%d에 해당하는 멤버가 없습니다.\n", id);
            return false;
        }

        this.memberMap.remove(id);
        return true;
    }

    public void showAllMember() {
        System.out.println("========================================");
        this.memberMap.forEach((id , member) -> System.out.println(member.showInfo()));
        System.out.println("========================================");
    }
}
