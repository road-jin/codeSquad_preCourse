package org.codesquad.stack;

import java.util.Scanner;

public class StackApp {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("총 스택 저장 공간의 크기 입력 >> ");
        StackImpl stack = new StackImpl(scanner.nextInt());

        String input = "";

        while(isExit(input)) {
            System.out.print("문자열 입력 >> ");
            input = scanner.next();
            printNotStackPush(stack, input);
        }

        System.out.print("스택에 저장된 모든 문자열 팝 : ");

        while (stack.length() != 0) {
            System.out.printf("%s ", stack.pop());
        }
    }

    private static boolean isExit(String input) {
        return !input.equals("그만");
    }

    private static void printNotStackPush(StackImpl stack, String input) {
        if (input.equals("그만")) {
            return;
        }

        if (!stack.push(input)) {
            System.out.println("스택이 꽉차서 push 불가!");
        }
    }
}
