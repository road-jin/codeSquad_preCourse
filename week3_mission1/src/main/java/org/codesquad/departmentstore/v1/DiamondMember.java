package org.codesquad.departmentstore.v1;

public class DiamondMember extends Member {

    public DiamondMember(String name, int buyPrice, int shoppingHours) {
        super(name, buyPrice, shoppingHours);
        super.grade = "DIAMOND";
        super.priceDiscountRatio = 0.1;
        super.pointRatio = 0.1;
        super.parkingFee = 1000;
        super.vipCallCenter = true;
    }
}
