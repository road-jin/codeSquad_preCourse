package org.codesquad.dice;

public class ResultView {

    public void addMoney() {
        System.out.println("소지금이 100원 증가하였습니다.");
    }

    public void reduceMoney() {
        System.out.println("소지금이 절반 감소하였습니다.");
    }

    public void getFruit(String fruitName) {
        System.out.println(fruitName + "을 얻었습니다.");
    }

    public void diceNumber(int diceNumber) {
        System.out.println("주사위 눈금 : " + diceNumber);
    }

    public void exit() {
        System.out.println("게임이 종료되었습니다.");
    }

    public void gameRound(int gameRound) {
        System.out.println("게임 라운드 : " + gameRound);
    }

    public void gamerInfo(String info) {
        System.out.println(info + "\n\n");
    }
}
