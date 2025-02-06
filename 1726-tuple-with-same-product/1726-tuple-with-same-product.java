class Solution {
    public int tupleSameProduct(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int ans = 0, n = nums.length;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int product = nums[i] * nums[j];
                ans += 8 * map.getOrDefault(product, 0);
                map.put(product, map.getOrDefault(product, 0) + 1);
            }
        }
        return ans;
    }
}
