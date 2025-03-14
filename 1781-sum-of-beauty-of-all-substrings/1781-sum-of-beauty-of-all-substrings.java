class Solution {
    public int beautySum(String s) {
        int sum = 0;
        for(int i = 0;i < s.length();i++){
            HashMap<Character, Integer> map = new HashMap<>();
            for(int j = i;j < s.length();j++){
                map.put(s.charAt(j),map.getOrDefault(s.charAt(j),0)+1);
                int max = 0;
                int min = Integer.MAX_VALUE;
                for(Map.Entry<Character, Integer> e : map.entrySet()){
                    max = Math.max(max,e.getValue());
                    min = Math.min(min,e.getValue());
                }
                sum += (max - min);
            }
        }
        return sum;
    }
}