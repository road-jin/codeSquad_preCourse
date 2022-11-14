package org.codesquad.util;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class FileUtilTest {

    @Test
    void read() {
        // given

        // when
        String readFileString = FileUtil.read();

        // then
        Assertions.assertNotNull(readFileString);
    }

    @Test
    void write() {
        // given

        // when
        FileUtil.write("A");
        String read = FileUtil.read();

        System.out.println(read);

        // then
        Assertions.assertEquals("A", read);
    }

}
