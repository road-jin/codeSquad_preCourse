package org.codesquad.material;

public class Powder implements Material {

    private final String name;

    public Powder() {
        this.name = "Powder";
    }

    @Override
    public String showName() {
        return this.name;
    }
}
