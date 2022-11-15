package org.codesquad.departmentstore;

import org.codesquad.departmentstore.v1.*;
import org.codesquad.departmentstore.v1.RedMember;
import org.codesquad.departmentstore.v2.MemberV2;
import org.codesquad.departmentstore.v2.MemberShip;

import java.util.List;

public class Question1 {

    public static void main(String[] args) {
        int[] buyPrices = {10000, 30000, 10000, 30000, 30000};

        Member james = new RedMember("James");
        Member tomas = new RedMember("Tomas");
        Member edward = new PlatinumMember("Edward");
        Member percy = new PlatinumMember("Percy");
        Member elizabet = new DiamondMember("Elizabet");

        int index = 0;
        for (Member member : List.of(james, tomas, edward, percy, elizabet)) {
            int buyPrice = buyPrices[index++];
            System.out.println(member.showReceipt(buyPrice, 2));
        }

        System.out.println("=================================================================");

        MemberV2 jamesV2 = new MemberV2("James", MemberShip.RED);
        MemberV2 tomasV2 = new MemberV2("Tomas", MemberShip.RED);
        MemberV2 edwardV2 = new MemberV2("Edward", MemberShip.PLATINUM);
        MemberV2 percyV2 = new MemberV2("Percy", MemberShip.PLATINUM);
        MemberV2 elizabetV2 = new MemberV2("Elizabet", MemberShip.DIAMOND);


        index = 0;
        for (MemberV2 member :  List.of(jamesV2, tomasV2, edwardV2, percyV2, elizabetV2)) {
            int buyPrice = buyPrices[index++];
            System.out.println(member.showReceipt(buyPrice, 2));
        }
    }
}
