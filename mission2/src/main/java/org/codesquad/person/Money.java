package org.codesquad.person;

public class Money {

    private Integer money;

    public Money(Integer money) {
        valid(money);
        this.money = money;
    }

    public void send(int buyPrice) {
        isBuyValid(buyPrice);
        this.money -= buyPrice;
    }

    public void give(int money) {
        this.money += money;
    }

    public Integer show() {
        return this.money;
    }

    public void isBuyValid(int buyPrice) {
        if (this.money < buyPrice) {
            throw new IllegalArgumentException("충분한 돈이 없습니다.");
        }
    }

    public void valid(int money) {
        if (money < 0) {
            throw new IllegalArgumentException("돈은 마이너스가 될수 없습니다.");
        }
    }
}
