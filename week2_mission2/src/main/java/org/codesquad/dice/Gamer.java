package org.codesquad.dice;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Gamer {

    private int money;
    private Map<Fruit, Integer> fruits;

    public Gamer() {
        this.money = 1000;
        this.fruits = new HashMap<>();
        init();
    }

    public Memento CreateMemento() {
        return new Memento(money, fruits);
    }

    public void restoreMemento(Memento memento) {
        this.money = memento.getMoney();
        this.fruits = memento.getFruits();
    }

    public int getMoney() {
        return money;
    }

    public void addMoney() {
        money += 100;
    }

    public void reduceMoney() {
        money /= 2;
    }

    public String getFruit() {
        Fruit fruit = Fruit.getFruit();
        Integer count = fruits.get(fruit);
        fruits.put(fruit, ++count);
        return fruit.getName();
    }

    public String info() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("소지금 : " + money);

        Arrays.stream(Fruit.values()).forEach(fruit ->
            stringBuilder.append(" " + fruit.getName() + " : " + fruits.get(fruit))
        );

        return stringBuilder.toString();
    }
    private void init() {
        Arrays.stream(Fruit.values()).forEach(fruit -> fruits.put(fruit, 0));
    }
}
