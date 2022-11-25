package org.codesquad;

import java.util.Scanner;

public class InputView {

    private static final Scanner SCANNER = new Scanner(System.in);

    public static String getNickName() {
        System.out.print("닉네임을 입력해주세요. >> ");
        String nickName = SCANNER.next();
        SCANNER.close();
        return nickName;
    }

}
