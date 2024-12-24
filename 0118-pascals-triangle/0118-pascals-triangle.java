class Solution {
    public List<List<Integer>> generate(int n) {
        List<List<Integer>> list = new ArrayList<>();
        for(int i = 1;i<=n;i++){
            List<Integer> res = new ArrayList<>();
            int ans = 1;
            res.add(ans);
            for(int j = 1;j<i;j++){
                ans*=(i-j);
                ans/=j;
                res.add(ans);
            }
            list.add(res);
        }
        return list;
    }
}