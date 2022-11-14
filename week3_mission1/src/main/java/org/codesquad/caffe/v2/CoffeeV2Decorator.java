package org.codesquad.caffe.v2;

public abstract class CoffeeV2Decorator implements CoffeeV2 {

    private CoffeeV2 coffee;

    public CoffeeV2Decorator(CoffeeV2 coffee) {
        this.coffee = coffee;
    }

    @Override
    public void brewing() {
        this.coffee.brewing();
    }
}
