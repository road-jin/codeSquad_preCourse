package org.codesquad;

public interface PlayerLevel {

    void run();

    void jump();

    void turn();

    void showLevelMessage();

    default void go(int count) {
        showLevelMessage();
        run();

        for (int i = 0; i < count; i++) {
            jump();
        }

        turn();
        System.out.println();
    }
}
