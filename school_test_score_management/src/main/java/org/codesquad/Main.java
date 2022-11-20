package org.codesquad;

import org.codesquad.config.AppConfig;
import org.codesquad.controller.MenuController;

public class Main {

    public static void main(String[] args) {
        AppConfig appConfig = AppConfig.getInstance();
        MenuController menuController = appConfig.getMenuController();
        menuController.run();
    }
}