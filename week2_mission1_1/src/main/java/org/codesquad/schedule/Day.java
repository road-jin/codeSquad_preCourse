package org.codesquad.schedule;

public class Day {
    private String work;

    public void saveTodayWork(String work) {
        this.work = work;
    }

    public String getTodayWork() {
        return work;
    }

    public String hasWork() {
        if (work == null) {
            return "없습니다.";
        }

        return work + "입니다.";
    }
}
