package org.codesquad.material;

public class Plastic implements Material {

    private final String name;

    public Plastic() {
        this.name = "Plastic";
    }

    @Override
    public String showName() {
        return this.name;
    }
}
