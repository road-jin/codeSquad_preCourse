package org.codesquad.departmentstore.v1;

public class PlatinumMember extends Member {

    public PlatinumMember(String name) {
        super(name);
    }

    @Override
    int calculatePrice(int buyPrice) {
        double PRICE_DISCOUNT_RATIO = 0.05;
        return buyPrice - (int) (buyPrice * PRICE_DISCOUNT_RATIO);
    }

    @Override
    int calculatePoint(int buyPrice) {
        double POINT_RATIO = 0.05;
        return (int) (buyPrice * POINT_RATIO);
    }

    @Override
    int calculateParkingFee(int shoppingHours) {
        int PARKING_FEE = 1000;
        return shoppingHours * PARKING_FEE;
    }
}
