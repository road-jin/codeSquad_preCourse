package org.codesquad.schedule;

import java.util.Scanner;

public class MonthScheduleView {
    private static final Scanner scanner = new Scanner(System.in);

    public static void init() {
        System.out.println("이번달 스케쥴 관리 프로그램.");
    }

    public static Menu getMenu() {
        System.out.print("\n할일(입력:1, 보기:2, 끝내기:3) >> ");
        return Menu.valueOf(scanner.nextInt());
    }

    public static int getInputDay() {
        System.out.print("날짜(1~30) >> ");
        return scanner.nextInt();
    }

    public static String getInputWork() {
        System.out.print("할일(빈칸없이입력) >> ");
        return scanner.next();
    }

    public static void show(int day, String work) {
        System.out.printf("%d일의 할 일은 %s\n", day, work);
    }

    public static void close() {
        System.out.println("프로그램을 종료합니다.");
        scanner.close();
    }
}
