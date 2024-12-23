class Solution {
    public List<Integer> majorityElement(int[] nums) {
        ArrayList<Integer> list = new ArrayList<>();
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int e : nums){
            map.put(e,map.getOrDefault(e,0)+1);
            if(map.get(e)>nums.length/3)
            if(!list.contains(e))
            list.add(e);
        }
        return list;
    }
}