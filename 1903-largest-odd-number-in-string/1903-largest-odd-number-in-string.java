class Solution {
    public String largestOddNumber(String num) {
        for(int j = num.length()-1;j>-1;j--){
            char i = num.charAt(j);
            if(i%2!=0){
                return num.substring(0,j+1);
            }
        }
        return "";
    }
}