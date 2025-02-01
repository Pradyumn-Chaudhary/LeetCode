class Solution {
    public boolean isArraySpecial(int[] nums) {
        int n = nums.length;
        if(n < 2)
        return true;
        for(int i = 1;i<n;i++){
            int check = nums[i] - nums[i-1];
            if(check%2==0)
            return false;
        }
        return true;
    }
}