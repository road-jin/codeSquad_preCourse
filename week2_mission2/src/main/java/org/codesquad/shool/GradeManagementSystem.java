package org.codesquad.shool;

import org.codesquad.shool.view.InputView;
import org.codesquad.shool.view.ResultView;

public class GradeManagementSystem {

    public void run() {
        ResultView.startDisplay();
        Menu menu = Menu.etc;

        while (isExit(menu)) {
            menu = InputView.selectMenu();
            menu.execution();
        }
    }

    private boolean isExit(Menu menu) {
        if (menu.equals(Menu.exit)) {
            InputView.close();
            return false;
        }

        return true;
    }
}
