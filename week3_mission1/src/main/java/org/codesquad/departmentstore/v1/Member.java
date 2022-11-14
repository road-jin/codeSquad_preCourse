package org.codesquad.departmentstore.v1;

import java.util.UUID;

public class Member {

    private final String id;
    private final String name;
    private final int buyPrice;
    private final int shoppingHour;
    protected String grade;
    protected int parkingFee;
    protected double priceDiscountRatio;
    protected double pointRatio;
    protected boolean vipCallCenter;


    public Member(String name, int buyPrice, int shoppingHour) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.buyPrice = buyPrice;
        this.shoppingHour = shoppingHour;
    }

    public void callCenter(boolean vipCallCenter) {
        String callCenterAssignment = "일반";

        if (vipCallCenter) {
            callCenterAssignment = "전문";
        }

        System.out.println(callCenterAssignment + " 상담원 연결");
    }

    public String showInfo() {
        return name + "님의 지불 금액은 " + calculatePrice() + " 원이고, 적립 포인트는 " + calculatePoint() + "점 입니다.\n" +
                "주차요금은 " + calculateParkingFee() + "원 입니다.\n";
    }

    private int calculatePrice() {
        return buyPrice - (int) (buyPrice * priceDiscountRatio);
    }

    private int calculatePoint() {
        return (int) (buyPrice * pointRatio);
    }

    private int calculateParkingFee() {
        return shoppingHour * parkingFee;
    }
}
