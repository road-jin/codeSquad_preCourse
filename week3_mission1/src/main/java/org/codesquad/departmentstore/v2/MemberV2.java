package org.codesquad.departmentstore.v2;

import java.util.UUID;

public class MemberV2 {

    private final UUID id;
    private final String name;
    private final MemberShip memberShip;
    private int buyPrice;
    private int shoppingHours;

    public MemberV2(String name, MemberShip memberShip, int buyPrice, int shoppingHours) {
        this.id = UUID.randomUUID();
        this.name = name;
        this.memberShip = memberShip;
        this.buyPrice = buyPrice;
        this.shoppingHours = shoppingHours;
    }

    public String showInfo() {
        return name + "님의 지불 금액은 " + memberShip.calculatePrice(buyPrice) +
                " 원이고, 적립 포인트는 " + memberShip.calculatePoint(buyPrice) + "점 입니다.\n" +
                "주차요금은 " + memberShip.calculateParkingFee(shoppingHours) + "원 입니다.\n";
    }

    public void callCenter() {
        System.out.println(memberShip.callCenterAssignment() + " 상담원 연결");
    }
}
