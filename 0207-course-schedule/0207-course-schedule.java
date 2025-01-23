class Solution {
    public static boolean helper(boolean vis[], boolean recursiveStack[], ArrayList<Integer> graph[],int curr){
vis[curr] = true;
recursiveStack[curr] = true;
for(int e : graph[curr]){
    if(recursiveStack[e])return false;
if(!vis[e]){
    if(!helper(vis,recursiveStack,graph,e))return false;
}
}
recursiveStack[curr] = false;
return true;
}

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList<Integer> graph[] = new ArrayList[numCourses];
        for(int i = 0;i<numCourses;i++){
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < prerequisites.length; i++) {
            graph[prerequisites[i][1]].add(prerequisites[i][0]);
        }
        boolean vis[] = new boolean[numCourses];
        boolean recursiveStack[] = new boolean[numCourses];
        for (int i = 0; i < numCourses; i++) {
            if (!vis[i]) {
                if (!helper(vis,recursiveStack,graph,i)) {
                    return false;
                }
            }
        }
        return true;
    }
}