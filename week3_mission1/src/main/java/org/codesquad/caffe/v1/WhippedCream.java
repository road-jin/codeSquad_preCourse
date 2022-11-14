package org.codesquad.caffe.v1;

import org.codesquad.caffe.v1.Coffee;

public class WhippedCream extends Coffee {

    public WhippedCream(Coffee coffee) {
        super(coffee);
    }

    @Override
    public void brewing() {
        super.brewing();
        System.out.print("Adding WhippedCream ");
    }
}
