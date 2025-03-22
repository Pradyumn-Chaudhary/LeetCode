class Solution {
    public int countCompleteComponents(int n, int[][] edges) {
        // Step 1: Build the graph using an adjacency list
        List<Integer>[] graph = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] edge : edges) {
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
        }

        int completeComponents = 0;
        boolean[] visited = new boolean[n];

        // Step 2: Find connected components using DFS
        for (int node = 0; node < n; node++) {
            if (!visited[node]) {
                Set<Integer> componentNodes = new HashSet<>();
                dfs(graph, visited, node, componentNodes);

                // Step 3: Check if the component is a complete graph
                if (isCompleteGraph(graph, componentNodes)) {
                    completeComponents++;
                }
            }
        }
        return completeComponents;
    }

    private void dfs(List<Integer>[] graph, boolean[] visited, int node, Set<Integer> componentNodes) {
        visited[node] = true;
        componentNodes.add(node);

        for (int neighbour : graph[node]) {
            if (!visited[neighbour]) {
                dfs(graph, visited, neighbour, componentNodes);
            }
        }
    }

    private boolean isCompleteGraph(List<Integer>[] graph, Set<Integer> componentNodes) {
        int size = componentNodes.size() - 1;

        for (int node : componentNodes) {
            if (graph[node].size() != size) {
                return false;
            }
        }
        return true;
    }
}