package org.codesquad.departmentstore.v1;

public class DiamondMember extends Member {

    public DiamondMember(String name) {
        super(name, true);
    }

    @Override
    int calculatePrice(int buyPrice) {
        double priceDiscountRatio = 0.1;
        return buyPrice - (int) (buyPrice * priceDiscountRatio);
    }

    @Override
    int calculatePoint(int buyPrice) {
        double pointRatio = 0.1;
        return (int) (buyPrice * pointRatio);
    }

    @Override
    int calculateParkingFee(int shoppingHours) {
        int parkingFee = 0;
        return shoppingHours * parkingFee;
    }
}
