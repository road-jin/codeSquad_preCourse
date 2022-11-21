package org.codesquad.material;

public class GenericPrinter<T extends Material> {

    private T material;

    public void setMaterial(T material) {
        this.material = material;
    }

    public T getMaterial() {
        return this.material;
    }

    @Override
    public String toString() {
        return "재료는 " + this.material.showName() + "입니다.";
    }
}
