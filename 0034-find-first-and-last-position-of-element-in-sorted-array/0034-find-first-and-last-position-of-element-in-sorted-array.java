class Solution {
    public int[] searchRange(int[] nums, int target) {
        int i = first(nums, target);
        int j = last(nums, target);
        return new int[] { i, j };
    }

    public int first(int[] nums, int target) {
        int low = 0, high = nums.length - 1, idx = -1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (nums[mid] == target) {
                idx = mid;
                high = mid - 1;
            } else if (nums[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return idx;
    }
    public int last(int[] nums, int target) {
        int low = 0, high = nums.length - 1, idx = -1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (nums[mid] == target) {
                idx = mid;
                low = mid + 1;
            } else if (nums[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return idx;
    }
}