package org.codesquad;

import org.codesquad.config.AppConfig;
import org.codesquad.controller.TestScoreManagementController;

public class Main {

    public static void main(String[] args) {
        AppConfig appConfig = AppConfig.getInstance();
        TestScoreManagementController testScoreManagementController = appConfig.getTestScoreManagementController();
        testScoreManagementController.run();
    }
}
