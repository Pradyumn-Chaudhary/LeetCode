class Solution {
    public int maxFrequency(int[] nums, int k) {
        System.out.println(nums.length);
        int res = 1;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            int low = i, high = i;
            long sum = nums[i];
            while(low<=high){
                if((long)nums[high] * (high-low+1) <= (long)(k + sum)){
                    res = Math.max(res,high-low+1);
                    high++;
                    if(high==nums.length){
                        return res;
                    }
                    sum += nums[high];
                }else{
                    sum -= nums[low++];
                }
            }
        }
        return res;
    }
}