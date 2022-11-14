package org.codesquad.caffe.v2;

public class MochaV2 extends CoffeeV2Decorator{

    public MochaV2(CoffeeV2 coffee) {
        super(coffee);
    }

    @Override
    public void brewing() {
        super.brewing();
        System.out.print(" Adding Mocha Syrup");
    }
}
