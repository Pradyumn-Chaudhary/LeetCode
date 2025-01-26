class Solution {
    public int findMin(int[] nums) {
        int n = nums.length;
        int low = 0,high = n - 1;
        while(low<=high){
            int mid = (low + high)/2;
            if(nums[mid]>=nums[low]){
                if(nums[low]>nums[high]){
                    low = mid + 1;
                }else{
                   return nums[low];
                }
            }else{
               high = mid;
            }
        }
        return -1;
    }
}