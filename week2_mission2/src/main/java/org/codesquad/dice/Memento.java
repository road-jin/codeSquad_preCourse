package org.codesquad.dice;

import java.util.Map;

public class Memento {

    private final int money;
    private final Map<Fruit, Integer> fruits;

    public Memento(int money, Map<Fruit, Integer> fruits) {
        this.money = money;
        this.fruits = fruits;
    }

    public int getMoney() {
        return money;
    }

    public Map<Fruit, Integer> getFruits() {
        return fruits;
    }
}
