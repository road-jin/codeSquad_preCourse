package org.codesquad.caffe.v1;

public class Coffee {

    private Coffee coffee;

    public Coffee() {
    }

    public Coffee(Coffee coffee) {
        this.coffee = coffee;
    }

    public void brewing() {
        coffee.brewing();
    }
}
