class Solution {
    public static boolean helper(int pre,int course,ArrayList<Integer> graph[],boolean vis[])
    {
        vis[pre] = true;
        for(int e : graph[pre]){
            if(e == course){
                return true;
            }
            if(!vis[e] && !helper(e,course,graph,vis)){
                return false;
            }
        }
        return false;
    }

    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
        int n = numCourses;
        ArrayList<Integer> graph[] = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < prerequisites.length; i++) {
            graph[prerequisites[i][0]].add(prerequisites[i][1]);
        }
        ArrayList<Boolean> list = new ArrayList<>();
        for(int i = 0;i<queries.length;i++){
            list.add(helper(queries[i][0],queries[i][1],graph,new boolean[n]));          
        }
        return list;
    }
}