package org.codesquad.departmentstore.v2;

public enum MemberShip {

    RED(0, 0.01, 3000, false),
    PLATINUM(0.05, 0.05, 1000, false),
    DIAMOND(0.1, 0.1, 0, true);

    private double priceDiscountRatio;
    private double pointRatio;
    private int parkingFee;
    private boolean vip;

    MemberShip(double priceDiscountRatio, double pointRatio, int parkingFee, boolean vip) {
        this.priceDiscountRatio = priceDiscountRatio;
        this.pointRatio = pointRatio;
        this.parkingFee = parkingFee;
        this.vip = vip;
    }

    public int calculatePrice(int buyPrice) {
        return buyPrice - (int) (buyPrice * priceDiscountRatio);
    }

    public int calculatePoint(int buyPrice) {
        return (int) (buyPrice * pointRatio);
    }

    public int calculateParkingFee(int shoppingHours) {
        return shoppingHours * parkingFee;
    }

    public String callCenterAssignment() {
        if (vip) {
            return "전문";
        }

        return "일반";
    }
}
