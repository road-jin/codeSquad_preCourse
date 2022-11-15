package org.codesquad.departmentstore.v1;

public class DiamondMember extends Member {

    public DiamondMember(String name) {
        super(name);
        super.vip = true;
    }

    @Override
    int calculatePrice(int buyPrice) {
        double PRICE_DISCOUNT_RATIO = 0.1;
        return buyPrice - (int) (buyPrice * PRICE_DISCOUNT_RATIO);
    }

    @Override
    int calculatePoint(int buyPrice) {
        double POINT_RATIO = 0.1;
        return (int) (buyPrice * POINT_RATIO);
    }

    @Override
    int calculateParkingFee(int shoppingHours) {
        int PARKING_FEE = 0;
        return shoppingHours * PARKING_FEE;
    }
}
