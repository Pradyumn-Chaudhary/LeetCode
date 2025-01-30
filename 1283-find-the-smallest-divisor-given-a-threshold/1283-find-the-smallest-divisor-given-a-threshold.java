class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int n = nums.length;
        Arrays.sort(nums);
        int max = nums[n-1];
        if(n>threshold){
            return -1;
        }
        int low = 1;
        int high = max;
        int mid = 1;
        int res = 1;
        while(low <= high){
            mid = (low + high) / 2;
            int sum = 0;
            for(int i = n - 1 ;i >= 0;i--){
                int d = (int)Math.ceil((double)nums[i]/mid);
                sum += d;
                if(d==1){
                    sum += i;
                    break;
                }
            }
            if(sum > threshold)
            low = mid + 1;
            else
            {
                high = mid - 1;
                res = mid;
            }
        }
        return res;
    }
}