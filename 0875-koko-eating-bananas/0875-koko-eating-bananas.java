class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int max = Integer.MIN_VALUE;
        for(int i = 0;i< piles.length;i++){
            if(piles[i]>max){
                max = piles[i];
            }
        }
        int low = 1,high = max;
        while(low<=high){
            int mid = (low + high) / 2;
            int hr = calculateK(piles,mid);
            if(hr > h){
                low = mid + 1;
            }else{
                high = mid - 1;
            }
        }
        return low;
    }

    public static int calculateK(int[] piles, int mid){
        int hr = 0;
        for(int i = 0;i < piles.length; i++){
            hr += Math.ceil((double)piles[i]/mid);
        }
        return hr;
    }
}