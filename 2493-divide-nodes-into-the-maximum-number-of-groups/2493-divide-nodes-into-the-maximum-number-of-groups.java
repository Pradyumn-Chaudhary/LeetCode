import java.util.*;

class Solution {
    public int magnificentSets(int n, int[][] edges) {
        List<Integer>[] graph = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) graph[i] = new ArrayList<>();

        // Build the adjacency list
        for (int[] edge : edges) {
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
        }

        int[] color = new int[n + 1]; // 0: unvisited, 1: color1, -1: color2
        Arrays.fill(color, 0);
        boolean[] visited = new boolean[n + 1];

        int maxGroups = 0;

        for (int i = 1; i <= n; i++) {
            if (color[i] == 0) { // If the node is unvisited
                List<Integer> component = new ArrayList<>();
                if (!isBipartite(graph, color, i, component)) return -1;

                int maxLevel = 0;
                for (int node : component) {
                    Arrays.fill(visited, false);
                    maxLevel = Math.max(maxLevel, bfs(graph, visited, node));
                }
                maxGroups += maxLevel;
            }
        }
        return maxGroups;
    }

    // Check if the graph is bipartite
    private boolean isBipartite(List<Integer>[] graph, int[] color, int start, List<Integer> component) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        color[start] = 1;
        component.add(start);

        while (!queue.isEmpty()) {
            int node = queue.poll();
            for (int neighbor : graph[node]) {
                if (color[neighbor] == 0) {  // If unvisited, assign opposite color
                    color[neighbor] = -color[node];
                    queue.add(neighbor);
                    component.add(neighbor);
                } else if (color[neighbor] == color[node]) {
                    return false;  // Graph is not bipartite
                }
            }
        }
        return true;
    }

    // BFS to find the longest shortest path
    private int bfs(List<Integer>[] graph, boolean[] visited, int start) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{start, 1});
        visited[start] = true;
        int maxDepth = 1;

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int node = curr[0], depth = curr[1];

            for (int neighbor : graph[node]) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    queue.add(new int[]{neighbor, depth + 1});
                    maxDepth = Math.max(maxDepth, depth + 1);
                }
            }
        }
        return maxDepth;
    }
}
