class Solution {
    public static boolean checkPossible(int[] bloomDay, long mid, int m, int k) {
        int b = 0, count = 0;
        for (int i = 0; i < bloomDay.length; i++) {
            if (bloomDay[i] <= mid)
                count++;
            else
                count = 0;
            if (count == k) {
                b++;
                count = 0;
            }
        }
        if (b >= m) {
            return true;
        }
        return false;
    }

    public int minDays(int[] bloomDay, int m, int k) {
        int n = bloomDay.length;
        long low = Integer.MAX_VALUE, high = Integer.MIN_VALUE;
        if ((long)m * k > n)
            return -1;
        for (int i = 0; i < n; i++) {
            if (low > bloomDay[i])
                low = bloomDay[i];
            if (high < bloomDay[i])
                high = bloomDay[i];
        }
        while (low <= high) {
            long mid = (low + high) / 2;
            boolean isPossible = checkPossible(bloomDay, mid, m, k);
            if (isPossible) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return (int) low;
    }
}