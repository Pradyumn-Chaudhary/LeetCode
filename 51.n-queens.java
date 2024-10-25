import java.util.*;
/*
 * @lc app=leetcode id=51 lang=java
 *
 * [51] N-Queens
 */

// @lc code=start
class Solution {
    public void saveBoard(char[][] Board, List<List<String>> allBoard) {
        String row = "";
        List<String> newBoard = new ArrayList<>();

        for (int i = 0; i < Board.length; i++) {
            row = "";
            for (int j = 0; j < Board[0].length; j++) {
                if (Board[i][j] == 'Q')
                    row += 'Q';
                else
                    row += '.';
            }
            newBoard.add(row);
        }
        allBoard.add(newBoard);
    }

    public Boolean isSafe(char[][] Board, int row, int col) {
        int r = row, c = col;
        //check Horizontal
        for (int j = 0; j <= c; j++) {
            if (Board[row][j] == 'Q')
                return false;
        }
        //check upper left diagonal
        for (int i = r, j = c; i >= 0 && j >= 0; i--, j--) {
            if (Board[i][j] == 'Q')
                return false;
        }
        //check lower left diagonal 
        for (int i = r, j = c; i < Board.length && j >= 0; i++, j--) {
            if (Board[i][j] == 'Q')
                return false;
        }
        return true;
    }

    public void helper(char[][] Board, List<List<String>> allBoard, int col) {
        if (col == Board.length) {
            saveBoard(Board, allBoard);
            return;
        }
        for (int row = 0; row < Board.length; row++) {
            if (isSafe(Board, row, col)) {
                Board[row][col] = 'Q';
                helper(Board, allBoard, col + 1);
                Board[row][col] = '.';
            }
        }
    }

    public List<List<String>> solveNQueens(int n) {
        char[][] Board = new char[n][n];
        List<List<String>> allBoard = new ArrayList<>();
        helper(Board, allBoard, 0);
        return allBoard;
    }
}
// @lc code=end

