class Solution {
    public int findMaxFish(int[][] grid) {
        int maxFish = 0;
        int drow[] = {-1, 0, 1, 0};
        int dcol[] = {0, -1, 0, 1};
        
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] > 0) {
                    // Perform DFS to calculate fish in the connected component
                    int fish = 0;
                    Stack<Pair<Integer, Integer>> stack = new Stack<>();
                    stack.push(new Pair<>(i, j));
                    
                    while (!stack.isEmpty()) {
                        Pair<Integer, Integer> p = stack.pop();
                        int r = p.getKey();
                        int c = p.getValue();
                        
                        // If already visited, continue
                        if (grid[r][c] == 0) continue;
                        
                        // Accumulate fish and mark as visited
                        fish += grid[r][c];
                        grid[r][c] = 0;
                        
                        // Explore neighbors
                        for (int k = 0; k < 4; k++) {
                            int nr = r + drow[k];
                            int nc = c + dcol[k];
                            if (nr >= 0 && nr < grid.length && nc >= 0 && nc < grid[0].length && grid[nr][nc] > 0) {
                                stack.push(new Pair<>(nr, nc));
                            }
                        }
                    }
                    
                    // Update the maximum fish count
                    maxFish = Math.max(maxFish, fish);
                }
            }
        }
        return maxFish;
    }
}
