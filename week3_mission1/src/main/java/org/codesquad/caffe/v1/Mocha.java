package org.codesquad.caffe.v1;

public class Mocha extends Coffee {

    public Mocha(Coffee coffee) {
        super(coffee);
    }

    @Override
    public void brewing() {
        super.brewing();
        System.out.print("Adding Mocha Syrup ");
    }
}
