class Solution {
    public int maximumCandies(int[] candies, long k) {
        int max = candies[0];
        for (int i = 0; i < candies.length; i++) {
            max = Math.max(max, candies[i]);
        }
        long low = 1, high = max;
        while (low <= high) {
            long mid = (low + high) / 2;
            boolean isTrue = check(candies, mid, k);
            if (isTrue) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return (int) high;
    }

    public static boolean check(int[] candies, long mid, long k) {
        long count = 0;
        for (int i = 0; i < candies.length; i++) {
            count += candies[i] / mid;
        }
        return count >= k;
    }
}