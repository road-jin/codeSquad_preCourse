package org.codesquad.caffe.v2;

import org.codesquad.caffe.v2.CoffeeV2;
import org.codesquad.caffe.v2.CoffeeV2Decorator;

public class WhippedCreamV2 extends CoffeeV2Decorator {

    public WhippedCreamV2(CoffeeV2 coffee) {
        super(coffee);
    }

    @Override
    public void brewing() {
        super.brewing();
        System.out.print(" Adding WhippedCream");
    }
}
