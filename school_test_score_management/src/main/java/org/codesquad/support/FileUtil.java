package org.codesquad.support;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileUtil {

    private static final String USER_DIRECTORY = System.getProperty("user.dir");
    private static final String FILE_PATH = "/school_test_score_management/src/main/resources/";
    private static final String FILE_NAME = "input.txt";

    private static String readFileString = null;

    public static String read() {
        try {
            readFileString = Files.readString(Path.of(USER_DIRECTORY + FILE_PATH + FILE_NAME), StandardCharsets.UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return readFileString;
    }

    public static void write(String writeString) {
        try {
            Files.writeString(Paths.get(USER_DIRECTORY + FILE_PATH + FILE_NAME), writeString, StandardCharsets.UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
