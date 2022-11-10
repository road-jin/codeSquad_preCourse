package org.codesquad.ticketingsystem;

import java.util.Arrays;

public enum SeatType {
    S(1),
    A(2),
    B(3),
    ETC(4);

    private int seatTypeNumber;

    SeatType(int seatTypeNumber) {
        this.seatTypeNumber = seatTypeNumber;
    }

    public static SeatType valueOf(int seatTypeNumber) {
        return Arrays.stream(SeatType.values())
                .filter(seatType -> seatType.getSeatTypeNumber() == seatTypeNumber)
                .findFirst()
                .orElse(ETC);
    }

    public int getSeatTypeNumber() {
        return seatTypeNumber;
    }

    public int getSeatTypeArrNumber() {
        return seatTypeNumber - 1;
    }
}
