package org.codesquad.departmentstore.v1;

import java.util.UUID;

public abstract class Member {

    private final UUID id;
    private final String name;
    private final boolean vip;
    protected

    public Member(String name, boolean vip) {
        this.id = UUID.randomUUID();
        this.name = name;
        this.vip = vip;
    }

    abstract int calculatePrice(int buyPrice);

    abstract int calculatePoint(int buyPrice);

    abstract int calculateParkingFee(int shoppingHours);

    public String showReceipt(int buyPrice, int shoppingHours) {
        return name + "님의 지불 금액은 " + calculatePrice(buyPrice) + " 원이고, 적립 포인트는 " + calculatePoint(buyPrice) + "점 입니다.\n" +
                "주차요금은 " + calculateParkingFee(shoppingHours) + "원 입니다.\n";
    }

    public String callCenter() {
        if (vip) {
            return "전문 상담원 연결";
        }

        return "일반 상담원 연결";
    }
}
