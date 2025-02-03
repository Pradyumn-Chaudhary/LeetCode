class Solution {
    public String frequencySort(String s) {
        String res = "";
        HashMap<Character,Integer> map = new HashMap<>();
        for(int i = 0;i<s.length();i++){
            map.put(s.charAt(i),map.getOrDefault(s.charAt(i),0)+1);
        }
        List<Map.Entry<Character,Integer>> list = new ArrayList(map.entrySet());
        list.sort(Map.Entry.comparingByValue(Comparator.reverseOrder()));
        for(Map.Entry<Character,Integer> entry : list){
            int c = entry.getValue();
            while(c-->0){
                res += entry.getKey();
            }
        }
        return res;
    }
}