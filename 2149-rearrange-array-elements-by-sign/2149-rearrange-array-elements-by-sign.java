class Solution {
    public int[] rearrangeArray(int[] nums) {
        int n = nums.length;
        int arr1[] = new int[n/2];
        int arr2[] = new int[n/2];
        int j = 0,k=0;
        for(int i = 0;i<n;i++){
            if(nums[i]<0){
                arr1[j] = nums[i];
                j++;
            }else{
                arr2[k] = nums[i];
                k++;
            }
        }
        for(int i  = 0,p=0;i < k && i < j ;i++,p++){
            nums[p] = arr2[i];
            p++;
            nums[p] = arr1[i];
        }
        return nums;
    }
}