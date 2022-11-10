package org.codesquad.ticketingsystem;

public class TicketingSystem {

    public void buyTicket() {
        Seats seats = new Seats();

        // 프로그램 시작 화면
        ResultView.startDisplay();
        int menu = 0;

        while(isExit(menu)) {
            // 메뉴 선택 화면
            menu = InputView.selectMenu();

            // 메뉴별 화면
            if (menu == 1) {
                SeatType seatType = InputView.selectSeatType();
                ResultView.seatView(seatType, seats.find(seatType));
                String name = InputView.getCustomerName();
                int seatNumber = InputView.selectSeatNumber();
                seats.save(seatType, name, seatNumber);
                continue;
            }

            if (menu == 2) {
                ResultView.allSeatView(seats);
                continue;
            }

            if (menu == 3) {
                SeatType seatType = InputView.selectSeatType();
                ResultView.seatView(seatType, seats.find(seatType));
                String customerName = InputView.getCustomerName();
                seats.remove(seatType, customerName);
                continue;
            }
        }
    }

    private boolean isExit(int menu) {
        if (menu == 4) {
            InputView.close();
            return false;
        }

        return true;
    }
}
