class Solution {
    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        Queue<Pair<Integer, Integer>> q = new LinkedList<>();
        int count = 0;
        int drow[] = { 0, -1, 0, 1 };
        int dcol[] = { -1, 0, 1, 0 };
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    q.add(new Pair<>(i, j));
                    grid[i][j] = 'A';
                    count++;
                }
                while (!q.isEmpty()) {
                    Pair<Integer, Integer> p = q.remove();
                    int r = p.getKey();
                    int c = p.getValue();
                    for (int k = 0; k < 4; k++) {
                        int nrow = r + drow[k];
                        int ncol = c + dcol[k];
                        if (nrow >= 0 && nrow < m && ncol >= 0 && ncol < n && grid[nrow][ncol] == '1') {
                            q.add(new Pair<>(nrow, ncol));
                            grid[nrow][ncol] = 'A';
                        }
                    }
                }
            }
        }
        return count;
    }
}