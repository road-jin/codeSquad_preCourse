package org.codesquad.ticketingsystem;

import java.util.Arrays;

public class ResultView {

    public static void startDisplay() {
        System.out.println("Shine 콘서트홀 에약 시스템입니다.");
    }

    public static void seatView(SeatType selectSeatType, String[] seats) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(selectSeatType.name() + " >> ");

        for (int i = 0; i < seats.length; i++) {
            if (seats[i] == null) {
                stringBuilder.append("___ ");
                continue;
            }

            stringBuilder.append(seats[i] + " ");
        }

        System.out.println(stringBuilder);
    }

    public static void allSeatView(Seats seats) {
        Arrays.stream(SeatType.values())
                .filter(seatType -> seatType != SeatType.ETC)
                .forEach(filterSeatType -> seatView(filterSeatType, seats.find(filterSeatType)));
        System.out.println("<<<조회를 완료하였습니다.>>>");
    }
}
