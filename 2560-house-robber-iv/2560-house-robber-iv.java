class Solution {
    public static boolean check(int[] nums, int k, int mid){
        int count = 0;
        for(int i = 0;i < nums.length;i++){
            if(nums[i] <= mid){
                count++;
                i++;
            }
        }
        return count >= k;
    }

    public int minCapability(int[] nums, int k) {
        int low = Integer.MAX_VALUE, high = Integer.MIN_VALUE;
        for(int i = 0;i < nums.length;i++){
            low = Math.min(low, nums[i]);
            high = Math.max(high, nums[i]);
        }
        while(low<=high){
            int mid = (low + high) / 2;
            if(check(nums, k, mid))
            high = mid - 1;
            else
            low = mid + 1;
        }
        return low;
    }
}