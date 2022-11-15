package org.codesquad.departmentstore.v1;

public class PlatinumMember extends Member {

    public PlatinumMember(String name) {
        super(name, false);
    }

    @Override
    int calculatePrice(int buyPrice) {
        double priceDiscountRatio = 0.05;
        return buyPrice - (int) (buyPrice * priceDiscountRatio);
    }

    @Override
    int calculatePoint(int buyPrice) {
        double pointRatio = 0.05;
        return (int) (buyPrice * pointRatio);
    }

    @Override
    int calculateParkingFee(int shoppingHours) {
        int parkingFee = 1000;
        return shoppingHours * parkingFee;
    }
}
