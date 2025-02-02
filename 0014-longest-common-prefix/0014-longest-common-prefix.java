class Solution {
    public String longestCommonPrefix(String[] strs) {
        int n = strs.length;
        String str = "";
        if(n == 1)
        return strs[0];
        int m = strs[0].length();
        for(int i = 0;i < m;i++){
            for(int j = 1;j < n;j++){
                if(strs[j].length() == i)
                return strs[j];
                if(strs[0].charAt(i) != strs[j].charAt(i)){
                    if(i == 0)
                    return "";
                    else
                    return strs[0].substring(0,i);
                }
            }
        }
        return strs[0];
    }
}