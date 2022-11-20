package org.codesquad.support.menu;

import org.codesquad.config.AppConfig;

import java.util.Arrays;

public enum MainMenu implements Menu{

    READ(1, "조회", () -> AppConfig.getInstance().getMenuController().read()),
    ADD(2, "추가", () -> AppConfig.getInstance().getMenuController().add()),
    EXIT(3, "끝내기", () -> {});
    private int menuNumber;
    private String title;
    private Runnable runnable;

    MainMenu(int menuNumber, String title, Runnable runnable) {
        this.menuNumber = menuNumber;
        this.title = title;
        this.runnable = runnable;
    }

    @Override
    public int getMenuNumber() {
        return menuNumber;
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public void execute() {
        runnable.run();
    }
}
