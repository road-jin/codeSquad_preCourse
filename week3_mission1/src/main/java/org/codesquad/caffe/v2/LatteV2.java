package org.codesquad.caffe.v2;

public class LatteV2 extends CoffeeV2Decorator {

    public LatteV2(CoffeeV2 coffee) {
        super(coffee);
    }

    @Override
    public void brewing() {
        super.brewing();
        System.out.print(" Adding Milk");
    }
}
