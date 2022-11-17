package org.codesquad;

public class MainBoard {

    public static void main(String[] args) {
        Player player = new Player();
        player.play(1);
        player.upgradeLevel(AdvancedLevel.getInstance());
        player.play(2);
        player.upgradeLevel(SuperLevel.getInstance());
        player.play(3);
    }
}