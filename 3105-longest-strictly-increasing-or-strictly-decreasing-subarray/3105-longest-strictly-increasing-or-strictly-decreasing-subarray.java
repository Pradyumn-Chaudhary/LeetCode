class Solution {
    public int longestMonotonicSubarray(int[] nums) {
        if(nums.length == 0)
        return 0;
        int de = 1,in = 1,maxLength = 1;
        for(int i = 1;i < nums.length;i++){
            if(nums[i]>nums[i-1]){
                in++;
                de = 1;
            }else if(nums[i]<nums[i-1]){
                de++;
                in = 1;
            }else{
                de = in = 1;
            }
            maxLength = Math.max(maxLength,Math.max(de,in));
        }
        return maxLength;
    }
}