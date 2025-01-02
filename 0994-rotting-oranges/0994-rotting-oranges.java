import java.util.*;

class Solution {
    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] arr = new int[m][n];
        Queue<Pair<Pair<Integer, Integer>, Integer>> q = new LinkedList<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2) {
                    q.add(new Pair<>(new Pair<>(i, j), 0));
                    arr[i][j] = 2;
                } else {
                    arr[i][j] = grid[i][j];
                }
            }
        }

        int time = 0;
        int[] drow = {-1, 0, 1, 0};
        int[] dcol = {0, 1, 0, -1};

        while (!q.isEmpty()) {
            Pair<Pair<Integer, Integer>, Integer> p1 = q.remove();
            int r = p1.getKey().getKey();
            int c = p1.getKey().getValue();
            int tm = p1.getValue();
            time = Math.max(time, tm);

            for (int i = 0; i < 4; i++) {
                int nrow = r + drow[i];
                int ncol = c + dcol[i];
                if (nrow >= 0 && nrow < m && ncol >= 0 && ncol < n && arr[nrow][ncol] == 1) {
                    arr[nrow][ncol] = 2;
                    q.add(new Pair<>(new Pair<>(nrow, ncol), tm + 1));
                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (arr[i][j] == 1) {
                    return -1;
                }
            }
        }
        return time;
    }
}
