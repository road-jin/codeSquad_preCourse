package org.codesquad.departmentstore.v1;

public class RedMember extends Member {

    public RedMember(String name) {
        super(name);
    }

    @Override
    int calculatePrice(int buyPrice) {
        double PRICE_DISCOUNT_RATIO = 0.0;
        return buyPrice - (int) (buyPrice * PRICE_DISCOUNT_RATIO);
    }

    @Override
    int calculatePoint(int buyPrice) {
        double POINT_RATIO = 0.01;
        return (int) (buyPrice * POINT_RATIO);
    }

    @Override
    int calculateParkingFee(int shoppingHours) {
        int PARKING_FEE = 3000;
        return shoppingHours * PARKING_FEE;
    }
}
