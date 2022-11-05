package org.codesquad.cafe;

import org.codesquad.person.Person;

public class Cafe {

    private final String name;
    private final Menus menus;

    public Cafe(String name) {
        this.name = name;
        this.menus = new Menus();
    }

    public void addMenu(Menu menu) {
        menus.add(menu);
    }

    public void removeMenu(Menu menu) {
        menus.remove(menu);
    }

    public void order(Person person, Menu menu) {
        menus.find(menu);
        person.sendMoney(menu.getPrice());
        log(person, menu);
    }

    private void log(Person person, Menu menu) {
        System.out.printf("%s님의 남은 돈은 %d원 입니다. %s에서 %s를 마셨습니다.\n",
                person.getName(),
                person.getMoney(),
                name,
                menu.getName());
    }
}
