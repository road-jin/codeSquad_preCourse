package org.codesquad.support.menu;

import org.codesquad.config.AppConfig;

public enum AddMenu implements Menu{

    STUDENT(1, "학생추가", () -> AppConfig.getInstance()
            .getMenuController()
            .addStudent()),
    SUBJECT(2, "과목추가", () -> AppConfig.getInstance()
            .getMenuController()
            .addSubject()),
    PREVIOUS(3, "이전", () -> {});

    private int menuNumber;
    private String title;
    private Runnable runnable;

    AddMenu(int menuNumber, String title, Runnable runnable) {
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
