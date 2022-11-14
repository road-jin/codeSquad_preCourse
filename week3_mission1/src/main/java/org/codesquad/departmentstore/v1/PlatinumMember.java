package org.codesquad.departmentstore.v1;

public class PlatinumMember extends Member {

    public PlatinumMember(String name, int buyPrice, int shoppingHours) {
        super(name, buyPrice, shoppingHours);
        super.grade = "PLATINUM";
        super.priceDiscountRatio = 0.05;
        super.pointRatio = 0.05;
        super.parkingFee = 3000;
    }
}
