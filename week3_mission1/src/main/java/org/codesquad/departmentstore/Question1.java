package org.codesquad.departmentstore;

import org.codesquad.departmentstore.v1.DiamondMember;
import org.codesquad.departmentstore.v1.Member;
import org.codesquad.departmentstore.v1.PlatinumMember;
import org.codesquad.departmentstore.v1.RedMember;
import org.codesquad.departmentstore.v2.Member2;
import org.codesquad.departmentstore.v2.MemberShip;

import java.util.Arrays;

public class Question1 {

    public static void main(String[] args) {
        Member james = new RedMember("James", 10000, 2);
        Member tomas = new RedMember("Tomas", 30000, 2);
        Member edward = new PlatinumMember("Edward", 10000, 2);
        Member percy = new PlatinumMember("Percy", 30000, 2);
        Member elizabet = new DiamondMember("Elizabet", 30000, 2);

        Arrays.asList(james, tomas, edward, percy, elizabet)
                .forEach(member -> System.out.println(member.showInfo()));

        System.out.println("=================================================================");

        Member2 james2 = new Member2("James", MemberShip.RED, 10000, 2);
        Member2 tomas2 = new Member2("Tomas", MemberShip.RED, 30000, 2);
        Member2 edward2 = new Member2("Edward", MemberShip.PLATINUM, 10000, 2);
        Member2 percy2 = new Member2("Percy", MemberShip.PLATINUM,30000, 2);
        Member2 elizabet2 = new Member2("Elizabet", MemberShip.DIAMOND, 30000, 2);

        Arrays.asList(james2, tomas2, edward2, percy2, elizabet2)
                .forEach(member -> System.out.println(member.showInfo()));
    }
}
