package org.codesquad.caffe.v1;

public class Latte extends Coffee {

    public Latte(Coffee coffee) {
        super(coffee);
    }

    @Override
    public void brewing() {
        super.brewing();
        System.out.print("Adding Mile ");
    }
}
