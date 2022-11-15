package org.codesquad.departmentstore.v1;

public class RedMember extends Member {

    public RedMember(String name) {
        super(name, false);
    }

    @Override
    int calculatePrice(int buyPrice) {
        double priceDiscountRatio = 0.0;
        return buyPrice - (int) (buyPrice * priceDiscountRatio);
    }

    @Override
    int calculatePoint(int buyPrice) {
        double pointRatio = 0.01;
        return (int) (buyPrice * pointRatio);
    }

    @Override
    int calculateParkingFee(int shoppingHours) {
        int parkingFee = 3000;
        return shoppingHours * parkingFee;
    }
}
