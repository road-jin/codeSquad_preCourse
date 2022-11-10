package org.codesquad.ticketingsystem;

import java.util.Arrays;

public class Seats {
    private String[][] seats = new String[3][10];

    public String[] find(SeatType seatType) {
        return seats[seatType.getSeatTypeArrNumber()];
    }

    public void save(SeatType seatType, String name, int seatNumber) {
        seats[seatType.getSeatTypeArrNumber()][seatNumber - 1] = name;
    }

    public void remove(SeatType seatType, String customerName) {
        String[] seatNames = seats[seatType.getSeatTypeArrNumber()];

        for (int i = 0 ; i < seatNames.length; i++) {
            if (seatNames[i] != null && seatNames[i].equals(customerName)) {
                seatNames[i] = null;
                return;
            }
        }
    }
}
