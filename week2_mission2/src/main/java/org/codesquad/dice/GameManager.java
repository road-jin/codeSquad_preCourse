package org.codesquad.dice;

import java.util.Random;

public class GameManager {

    private final Random random;
    private final ResultView resultView;

    public GameManager() {
        this.random = new Random();
        this.resultView = new ResultView();
    }

    public void run() {
        Gamer gamer = new Gamer();
        Memento memento = gamer.CreateMemento();
        int gameRound = 1;

        while(isExit(gameRound, gamer.getMoney())) {
            resultView.gameRound(gameRound);
            memento = createMementoRule(gamer, memento);
            restoreRule(gamer, memento);

            int diceNumber = rollDice();
            gamerSetState(gamer, diceNumber);
            resultView.gamerInfo(gamer.info());
            gameRound++;
        }
    }

    private boolean isExit(int gameCount, int money) {
        if (money == 0 && gameCount > 100) {
            resultView.exit();
            return false;
        }

        return true;
    }

    private Memento createMementoRule(Gamer gamer, Memento memento) {
        if (gamer.getMoney() > memento.getMoney()) {
            memento = gamer.CreateMemento();
        }
        return memento;
    }

    private void restoreRule(Gamer gamer, Memento memento) {
        if (memento.getMoney() / 2 > gamer.getMoney()) {
            gamer.restoreMemento(memento);
        }
    }

    private int rollDice() {
        int diceNumber = random.nextInt(6) + 1;
        resultView.diceNumber(diceNumber);
        return diceNumber;
    }

    private void gamerSetState(Gamer gamer, int diceNumber) {
        if (diceNumber == 1 || diceNumber == 3) {
            resultView.addMoney();
            gamer.addMoney();
        }

        if (diceNumber == 2 || diceNumber == 4) {
            resultView.reduceMoney();
            gamer.reduceMoney();
        }

        if (diceNumber == 6) {
            resultView.getFruit(gamer.getFruit());
        }
    }
}
