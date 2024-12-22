class Solution {
    public int numOfStrings(String[] patterns, String word) {
        int L = word.length();
        int c = 0;
        for(int i = 0;i < patterns.length;i++){
            int l = patterns[i].length();
            for(int j = 0;j<=L-l;j++){
                String s = word.substring(j,j+l);
                if(s.equals(patterns[i])){
                    c++;
                    break;
                }
            }
        }
            return c;
    }
}