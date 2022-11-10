package org.codesquad.ticketingsystem;

import java.util.Scanner;

public class InputView {
    private static Scanner scanner = new Scanner(System.in);

    public static int selectMenu() {
        System.out.print("\n예약:1, 조회:2, 취소:3, 끝내기:4 >> ");
        int menu = scanner.nextInt();

        if (menu > 4) {
            System.out.println("잘못된 메뉴 선택 입니다.\n");
            return selectMenu();
        }

        return menu;
    }

    public static SeatType selectSeatType() {
        System.out.print("S(1), A(2), B(3) >> ");
        SeatType seatType = SeatType.valueOf(scanner.nextInt());

        if (seatType.equals(SeatType.ETC)) {
            System.out.println("잘못된 좌석타입 선택 입니다.\n");
            return selectSeatType();
        }

        return seatType;
    }

    public static String getCustomerName() {
        System.out.print("이름 >> ");
        return scanner.next();
    }

    public static int selectSeatNumber() {
        System.out.print("번호 >> ");
        int seatNumber = scanner.nextInt();

        if (seatNumber > 10) {
            return selectSeatNumber();
        }
        return seatNumber;
    }

    public static void close() {
        scanner.close();
    }
}
