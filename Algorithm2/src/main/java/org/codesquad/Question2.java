package org.codesquad;

import java.util.Stack;

public class Question2 {

    private static int answer = 0;
    private static Stack<Integer> stack = new Stack<>();
    private static int[][] board = {{0,0,0,0,0},
            {0,0,1,0,3},
            {0,2,5,0,1},
            {4,2,4,4,2},
            {3,5,1,3,1}};

    public static void main(String[] args) {
        // https://school.programmers.co.kr/learn/courses/30/lessons/64061
        int[] moves = {1,5,3,5,1,2,1,4};
        stack.push(0);

        for (int i = 0; i < moves.length; i++) {
            int x = moves[i] - 1;
            boardRepeat(x, 0);
        }
    }

    public static void boardRepeat(int x, int y) {
        if (y >= board.length) {
            return;
        }

        if (board[y][x] > 0) {
            int doll = board[y][x];
            Integer previousDoll = stack.peek();
            board[y][x] = 0;

            if (previousDoll == doll) {
                stack.pop();
                answer += 2;
                return;
            }

            stack.push(doll);
            return;
        }

        boardRepeat(x, y + 1);
    }
}
