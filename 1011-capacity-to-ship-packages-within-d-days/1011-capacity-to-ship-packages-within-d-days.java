class Solution {
    public static boolean checkMinimum(int[] weights, long mid, int days) {
        int currWeight = 0;
        int currDays = 0;
        for (int i = 0; i < weights.length; i++) {
            if (currWeight < mid) {
                currWeight += weights[i];
            }
            if (currWeight == mid) {
                currWeight = 0;
                currDays++;
            } else if (currWeight > mid) {
                currWeight = weights[i];
                currDays++;
            }
        }
        if (currWeight != 0) {
            currDays++;
        }
        if (currDays > days) {
            return false;
        }
        return true;
    }

    public int shipWithinDays(int[] weights, int days) {
        int n = weights.length;
        long low = Integer.MIN_VALUE, high = 0;
        for (int i = 0; i < n; i++) {
            if (weights[i] > low)
                low = weights[i];
            high += weights[i];
        }
        while (low <= high) {
            long mid = (low + high) / 2;
            boolean possible = checkMinimum(weights, mid, days);
            if (possible)
                high = mid - 1;
            else
                low = mid + 1;
        }
        return (int) low;
    }
}