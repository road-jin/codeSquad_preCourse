package org.codesquad;

public class Player {

    private PlayerLevel level;

    public Player() {
        this.level = new BeginnerLevel();
    }

    public PlayerLevel getLevel() {
        return this.level;
    }

    public void play(int time) {
        this.level.go(time);
    }

    public void upgradeLevel(PlayerLevel level) {
        this.level = level;
    }
}
