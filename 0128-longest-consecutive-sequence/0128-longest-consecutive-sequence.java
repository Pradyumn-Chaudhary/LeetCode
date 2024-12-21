class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length == 0)
        return 0;
        HashSet<Integer> set = new HashSet<>();
        int lc = 1;
        for(int i = 0;i<nums.length;i++){
            set.add(nums[i]);
        }
        for(int e : set){
            if(!set.contains(e-1)){
                int z = 1;
                int k = e;
                while(true){
                    if(!set.contains(k+1))
                    break;
                    z++;
                    k++;
                }
                lc = Math.max(lc,z);
            }
        }
        return lc;
    }
}