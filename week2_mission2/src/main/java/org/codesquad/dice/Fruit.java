package org.codesquad.dice;

import java.util.Arrays;

public enum Fruit {
    APPLE(0,"사과"),
    SHINE_MUSCAT(1, "샤인머스켓"),
    ORANGE(2, "귤");

    private int number;
    private String name;
    private static int count = 0;

    Fruit(int number, String name) {
        this.number = number;
        this.name = name;
    }

    public int getNumber() {
        return number;
    }

    public String getName() {
        return name;
    }

    public static Fruit getFruit() {
        int length = values().length;
        Fruit fruit = Arrays.stream(values())
                .filter(f -> count % length == f.getNumber())
                .findFirst()
                .orElseThrow();
        count++;
        return fruit;
    }
}
