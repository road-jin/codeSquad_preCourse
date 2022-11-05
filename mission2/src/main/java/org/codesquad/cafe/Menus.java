package org.codesquad.cafe;

import org.codesquad.cafe.Menu;

import java.util.HashSet;
import java.util.Set;

public class Menus {

    private final Set<Menu> menuSet;

    public Menus() {
        this.menuSet = new HashSet<>();
    }

    public void add(Menu menu) {
        menuSet.add(menu);
    }

    public void remove(Menu menu) {
        menuSet.remove(menu);
    }

    public Menu find(Menu searchMenu) {
        return menuSet.stream()
                .filter(menu -> menu.equals(searchMenu))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("찾는 메뉴가 없습니다."));
    }
}
