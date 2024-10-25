class Solution {
    public int singleNumber(int[] nums) {
        int i = 1;
        int j = nums[0];
        while(i<nums.length){
            j ^= nums[i];
            i++;
        }
        return j;
    }
}