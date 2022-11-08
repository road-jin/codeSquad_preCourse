package org.codesquad.schedule;

import java.util.Arrays;
import java.util.function.Consumer;

public enum Menu {
    ready(0, (days) -> {}),
    save(1, (days) -> save(days)),
    show(2, (days) -> show(days)),
    exit(3, (days) -> MonthScheduleView.close());

    private int number;
    private Consumer<Day[]> consumer;

    Menu(int number, Consumer<Day[]> consumer) {
        this.number = number;
        this.consumer = consumer;
    }

    public void accept(Day[] days) {
        consumer.accept(days);
    }

    public static Menu valueOf(int number) {
        return Arrays.stream(Menu.values())
                .filter(menu -> menu.number == number)
                .findFirst()
                .orElseThrow();
    }

    private static void save(Day[] days) {
        int inputDay = MonthScheduleView.getInputDay();
        String work = MonthScheduleView.getInputWork();
        days[inputDay].saveTodayWork(work);
    }

    private static void show(Day[] days) {
        int day = MonthScheduleView.getInputDay();
        MonthScheduleView.show(day, days[day].hasWork());
    }
}
