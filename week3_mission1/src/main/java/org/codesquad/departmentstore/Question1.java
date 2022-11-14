package org.codesquad.departmentstore;

import org.codesquad.departmentstore.v1.DiamondMember;
import org.codesquad.departmentstore.v1.Member;
import org.codesquad.departmentstore.v1.PlatinumMember;
import org.codesquad.departmentstore.v1.RedMember;
import org.codesquad.departmentstore.v2.MemberV2;
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

        MemberV2 jamesV2 = new MemberV2("James", MemberShip.RED, 10000, 2);
        MemberV2 tomasV2 = new MemberV2("Tomas", MemberShip.RED, 30000, 2);
        MemberV2 edwardV2 = new MemberV2("Edward", MemberShip.PLATINUM, 10000, 2);
        MemberV2 percyV2 = new MemberV2("Percy", MemberShip.PLATINUM,30000, 2);
        MemberV2 elizabetV2 = new MemberV2("Elizabet", MemberShip.DIAMOND, 30000, 2);

        Arrays.asList(jamesV2, tomasV2, edwardV2, percyV2, elizabetV2)
                .forEach(member -> System.out.println(member.showInfo()));
    }
}
