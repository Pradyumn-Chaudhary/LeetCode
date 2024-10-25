class Solution {
    public boolean isPalindrome(String s) {
        int left = 0;
        String s2 = s.toLowerCase();
        int right = s2.length() - 1;
        
        while (left < right) {
            if (!Character.isLetterOrDigit(s2.charAt(left))) {
                left++;
            } else if (!Character.isLetterOrDigit(s2.charAt(right))) {
                right--;
            } else {
                if (s2.charAt(left) != s2.charAt(right)) {
                    return false;
                }
                left++;
                right--;
            }
        }
        return true;
    }
}