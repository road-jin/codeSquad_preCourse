package org.codesquad.schedule;

import java.time.LocalDate;
import java.time.YearMonth;

public class MonthSchedule {

    private final Day[] days;
    private Menu menu;

    public MonthSchedule() {
        int lastDay = YearMonth.from(LocalDate.now()).lengthOfMonth();
        this.days = new Day[lastDay];
        initDays();
        this.menu = Menu.ready;
    }

    public void initDays() {
        for (int i = 0; i < days.length; i++) {
            days[i] = new Day();
        }
    }

    public void run() {
        MonthScheduleView.init();

        while(isExit()) {
            menuExecute(MonthScheduleView.getMenu());
        }
    }

    public boolean isExit() {
        if (menu.equals(Menu.exit)) {
            return false;
        }

        return true;
    }

    public void menuExecute(Menu menu) {
        menu.accept(days);
    }
}