class Solution {
    public int majorityElement(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i = 0;i<nums.length;i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }
        for(int e : map.keySet()){
            if(map.get(e)>nums.length/2)
            return e;;
        }
         return -1;
    }
}