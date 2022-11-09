package org.codesquad;

import java.util.Stack;

public class Question2 {

    private static int result = 0;
    private static Stack<Integer> stack = new Stack<>();

    public static void main(String[] args) {
        // https://school.programmers.co.kr/learn/courses/30/lessons/64061
        int[][] board = {{0,0,0,0,0},
                        {0,0,1,0,3},
                        {0,2,5,0,1},
                        {4,2,4,4,2},
                        {3,5,1,3,1}};
        int[] moves = {1,5,3,5,1,2,1,4};
        stack.push(0);

        for (int i = 0; i < moves.length; i++) {
            int x = moves[i] - 1;
            boardRepeat(board, x, 0);
        }

    }

    public static void boardRepeat(int[][] board, int x, int y) {
        if (y >= board.length) {
            return;
        }

        if (board[y][x] > 0) {
            int doll = board[y][x];
            Integer previousDoll = stack.peek();
            board[y][x] = 0;

            if (previousDoll == doll) {
                stack.pop();
                result += 2;
                return;
            }

            stack.push(doll);
            return;
        }

        boardRepeat(board, x, y + 1);
    }
}
