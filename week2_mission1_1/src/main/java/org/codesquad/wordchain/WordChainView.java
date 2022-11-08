package org.codesquad.wordchain;

import java.util.Scanner;

public class WordChainView {

    private static final Scanner scanner = new Scanner(System.in);

    public static int getUserCount() {
        System.out.println("끝말잇기 게임을 시작합니다!!");
        System.out.print("게임에 참여하는 인원은 몇명입니까? >> ");
        return scanner.nextInt();
    }

    public static String[] getUserNames(int userCount) {
        String[] names = new String[userCount];

        for (int i = 0; i < userCount; i++) {
            System.out.print("참가자 이름을 입력해주세요. >> ");
            names[i] = scanner.next();
        }

        return names;
    }

    public static void init() {
        System.out.println("시작 단어는 \"기러기\"입니다.");
    }

    public static String getWord(String name) {
        System.out.printf("%s>> ", name);
        return scanner.next();
    }

    public static void gameOver(String name) {
        System.out.printf("%s이 졌습니다.", name);
        scanner.close();
    }
}
