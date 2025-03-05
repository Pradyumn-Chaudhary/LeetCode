class Solution {
    public int myAtoi(String s) {
        s = s.trim();
        if(s.length() == 0){
            return 0;
        }

        int i = 0;
        int sign = 1;
        long result = 0;
        
        if(i < s.length() && s.charAt(i) == '-' || s.charAt(i) == '+'){
            sign = s.charAt(i) == '+' ? 1 : -1;
            i++;
        }

        while(i < s.length() && Character.isDigit(s.charAt(i))){
            result = result * 10 + (s.charAt(i) - '0');
            if(result > Integer.MAX_VALUE){
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            i++;
        }
        return (int) (sign * result);
    }
}