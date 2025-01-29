import java.util.*;

class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        ArrayList<Integer>[] graph = new ArrayList[n + 1];  // Adjacency list

        for (int i = 0; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] edge : edges) {
            boolean[] vis = new boolean[n + 1];  // Reset visited for every edge
            if (dfs(graph, edge[0], edge[1], -1, vis)) {
                return edge;  // Found a cycle → this edge is redundant
            }
            graph[edge[0]].add(edge[1]);  // Add edge to the graph
            graph[edge[1]].add(edge[0]);
        }
        return new int[]{-1, -1}; // No redundant edge found
    }

    private boolean dfs(ArrayList<Integer>[] graph, int src, int dest, int parent, boolean[] vis) {
        if (src == dest) return true;  // Cycle detected

        vis[src] = true;
        for (int neighbor : graph[src]) {
            if (neighbor == parent) continue; // Skip parent to prevent false cycle detection
            if (vis[neighbor] || dfs(graph, neighbor, dest, src, vis)) {
                return true;  // Cycle found
            }
        }
        return false;
    }
}
