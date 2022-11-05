package org.codesquad.cafe;

import java.util.Objects;
import java.util.UUID;

public class Menu {

    private final UUID menuId;
    private final String name;
    private final Integer price;

    public Menu(String name, int price) {
        this.menuId = UUID.randomUUID();
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Menu menu = (Menu) o;
        return Objects.equals(menuId, menu.menuId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(menuId);
    }
}
