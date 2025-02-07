class Solution {
    public int[] queryResults(int limit, int[][] queries) {
        int n = queries.length;
        int result[] = new int[n];
        int count = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            if (map.containsValue(queries[i][1])) {
                count--;
            }
            if (map.containsKey(queries[i][0])) {
                if(map.get(queries[i][0]) != queries[i][1])
                count--;
            }
            count++;
            map.put(queries[i][0], queries[i][1]);
            result[i] = count;
        }
        return result;
    }
}