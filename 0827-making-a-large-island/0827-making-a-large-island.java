class Solution {
    int[] directions = {0, 1, 0, -1, 0};

    public int largestIsland(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int maxArea = 0;
        int islandId = 2;
        Map<Integer, Integer> areaMap = new HashMap<>();
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    int area = dfs(grid, i, j, n, m, islandId);
                    areaMap.put(islandId, area);
                    islandId++;
                }
            }
        }
        
        maxArea = Math.max(maxArea, areaMap.values().stream().max(Integer::compare).orElse(0));
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 0) {
                    Set<Integer> uniqueIslands = new HashSet<>();
                    for (int k = 0; k < 4; k++) {
                        int x = i + directions[k];
                        int y = j + directions[k + 1];
                        if (x >= 0 && x < n && y >= 0 && y < m && grid[x][y] > 1) {
                            uniqueIslands.add(grid[x][y]);
                        }
                    }
                    int combinedArea = 1;
                    for (int island : uniqueIslands) {
                        combinedArea += areaMap.get(island);
                    }
                    maxArea = Math.max(maxArea, combinedArea);
                }
            }
        }
        
        return maxArea;
    }

    private int dfs(int[][] grid, int i, int j, int n, int m, int islandId) {
        if (i < 0 || i >= n || j < 0 || j >= m || grid[i][j] != 1) {
            return 0;
        }
        grid[i][j] = islandId;
        int area = 1;
        for (int k = 0; k < 4; k++) {
            int x = i + directions[k];
            int y = j + directions[k + 1];
            area += dfs(grid, x, y, n, m, islandId);
        }
        return area;
    }
}
