class Solution {
    public int[] minimumCost(int n, int[][] edges, int[][] query) {
        int m = edges.length;
        int q = query.length;
        DisjointUnionSets dsu = new DisjointUnionSets(n);
        for(int i = 0; i < m; i++){
            int l = edges[i][0];
            int r = edges[i][1];
            int w = edges[i][2];
            dsu.union(l, r, w);
        }
        int[] ans = new int[q];
        for(int i = 0; i < q; i++){
            int l = query[i][0];
            int r = query[i][1];
            if(l == r){
                ans[i] = 0;
                continue;
            }
            int u = dsu.find(l);
            int v = dsu.find(r);
            if(u != v){
                ans[i] = -1;
            }else{
                ans[i] = dsu.and[u];
            }
        }
        return ans;
    }
    static class DisjointUnionSets {
        int[] rank, parent, and;
        int n;
        int count;
        public DisjointUnionSets(int n){
            rank = new int[n];
            parent = new int[n];
            and = new int[n];
            count = n;
            this.n = n;
            makeSet();
        }
        void makeSet(){
            for (int i = 0; i < n; i++) {
                parent[i] = i;
                and[i] = -1;
            }
        }
        int find(int x){
            if (parent[x] != x) {
                parent[x] = find(parent[x]);
            }
     
            return parent[x];
        }
        void union(int x, int y, int w){
            int xRoot = find(x), yRoot = find(y);
    
            if (xRoot == yRoot){
                and[xRoot] &= w;
                return;
            }
    
            if (rank[xRoot] < rank[yRoot]){
                parent[xRoot] = yRoot;
                if(and[xRoot] == -1){
                    and[xRoot] = w;
                }
                if(and[yRoot] == -1){
                    and[yRoot] = w;
                }
                and[xRoot] = and[xRoot] & and[yRoot] & w;
                and[yRoot] = and[xRoot] & and[yRoot] & w;
            }
            else if (rank[yRoot] < rank[xRoot]){
                parent[yRoot] = xRoot;
                if(and[xRoot] == -1){
                    and[xRoot] = w;
                }
                if(and[yRoot] == -1){
                    and[yRoot] = w;
                }
                and[xRoot] = and[xRoot] & and[yRoot] & w;
                and[yRoot] = and[xRoot] & and[yRoot] & w;
            }
            else{
                parent[yRoot] = xRoot;
                rank[xRoot] = rank[xRoot] + 1;
                if(and[xRoot] == -1){
                    and[xRoot] = w;
                }
                if(and[yRoot] == -1){
                    and[yRoot] = w;
                }
                and[xRoot] = and[xRoot] & and[yRoot] & w;
                and[yRoot] = and[xRoot] & and[yRoot] & w;
            }
            count -= 1;
        }
        int num(){
            return count;
        }
    }
}