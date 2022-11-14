package org.codesquad.domain;

import org.codesquad.controller.TestScoreManagementController;

import java.util.Arrays;
import java.util.function.Consumer;
import java.util.function.Supplier;

public enum Menu {

    READ(1, "조회", (controller) -> controller.read()),
    ADD(2, "추가", (controller) -> controller.add()),
    EDIT(3, "수정", (controller) -> controller.edit()),
    REMOVE(4, "삭제", (controller) -> controller.remove()),
    EXIT(5, "끝내기", (controller) -> {}),
    ETC(6, "기타", (controller) -> {});

    private int menuNumber;
    private String title;
    private Consumer<TestScoreManagementController> consumer;

    Menu(int menuNumber, String title, Consumer<TestScoreManagementController> consumer) {
        this.menuNumber = menuNumber;
        this.title = title;
        this.consumer = consumer;
    }

    public static Menu valueOf(int menuNumber) {
        return Arrays.stream(values())
                .filter(menu -> menu.menuNumber == menuNumber)
                .findFirst()
                .orElse(ETC);
    }

    public int getMenuNumber() {
        return menuNumber;
    }

    public String getTitle() {
        return title;
    }

    public void execute(TestScoreManagementController controller) {
        consumer.accept(controller);
    }
}
