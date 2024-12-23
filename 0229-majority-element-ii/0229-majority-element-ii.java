class Solution {
    public List<Integer> majorityElement(int[] nums) {
        ArrayList<Integer> list = new ArrayList<>();
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int e : nums){
            map.put(e,map.getOrDefault(e,0)+1);
        }
        for(int e : map.keySet()){
            if(map.get(e)>nums.length/3)
            list.add(e);
        }
        return list;
    }
}