class Solution {
    public static ArrayList<Integer>[] reverseGraph(int[][]graph,int n,int[] indegree){
        ArrayList<Integer> reverse[] = new ArrayList[n];
        for(int i = 0;i<n;i++){
            reverse[i] = new ArrayList<>();
        }
        for(int i = 0;i<n;i++){
            for(int e : graph[i]){
                indegree[i]++;
                reverse[e].add(i);
            }
        }
        return reverse;
    }

    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        int indegree[] = new int[n];
        ArrayList<Integer> reverse[] = reverseGraph(graph,n,indegree);

        Queue<Integer> q = new LinkedList<>();
        for(int i = 0;i<n;i++){
            if(indegree[i]==0){
                q.add(i);
            }
        }
        ArrayList<Integer> safe = new ArrayList<>();
        while(!q.isEmpty()){
            int z = q.poll();
            safe.add(z);
            for(int e : reverse[z]){
                indegree[e]--;
                if(indegree[e]==0){
                    q.add(e);
                }
            }
        }
        Collections.sort(safe);
        return safe;
    }
}