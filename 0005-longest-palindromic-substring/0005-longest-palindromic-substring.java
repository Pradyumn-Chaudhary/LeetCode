class Solution {
    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0)
            return "";
        String res = s.substring(0, 1);
        int i = 0, j = 2, sz = 1;
        while (j < s.length()) {
            int left = i, right = j;
            while (left <= right && left >= 0 && right < s.length()) {
                if (s.charAt(left) != s.charAt(right)) {
                    break;
                }
                if (sz < (right - left) + 1) {
                    res = s.substring(left, right + 1);
                    sz = (right - left) + 1;
                }
                left--;
                right++;
            }
            i++;
            j++;
        }

        i = 0;
        j = 1;
        while (j < s.length()) {
            int left = i, right = j;
            while (left <= right && left >= 0 && right < s.length()) {
                if (s.charAt(left) != s.charAt(right)) {
                    break;
                }
                if (sz < (right - left) + 1) {
                    res = s.substring(left, right + 1);
                    sz = (right - left) + 1;
                }
                left--;
                right++;
            }
            i++;
            j++;
        }
        return res;
    }
}