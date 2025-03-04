class Solution {
    public static boolean check(int[] nums, long mid, int k){
        int count = 1;
        int sum = 0;
        for(int e : nums){
            sum += e;
            if(sum > mid){
                sum = e;
                count++;
            }
        }
        if(count > k)
        return false;
        return true;
    }

    public int splitArray(int[] nums, int k) {
        long low = Integer.MIN_VALUE;
        long high = 0;
        for(int e : nums){
            high += (long)e;
        }
        while(low <= high){
            long mid = (low + high) / 2;
            boolean isPossible = check(nums,mid,k);
            if(isPossible){
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }
        return (int) low;
    }
}