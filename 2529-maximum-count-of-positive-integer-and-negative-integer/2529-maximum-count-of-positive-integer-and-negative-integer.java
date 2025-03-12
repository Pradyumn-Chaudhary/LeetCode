class Solution {
    public int maximumCount(int[] nums) {
        int neg = 0, pos = 0;
        int low = 0, high = nums.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (nums[mid] < 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        if (low >= 0 && nums[low] >= 0) {
            low--;
        }
        if (low < 0) {
            low = 0;
        }
        if (nums[low] < 0) {
            neg += low + 1;
            low++;
        }
        while (low < nums.length && nums[low] == 0) {
            low++;
        }
        if (low < nums.length && nums[low] > 0) {
            pos += nums.length - low;
        }
        System.out.println(neg);
        System.out.println(pos);
        return Math.max(pos, neg);
    }
}