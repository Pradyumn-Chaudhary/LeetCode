class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        char S[] = s.toCharArray();
        Arrays.sort(S);
        char T[] = t.toCharArray();
        Arrays.sort(T);
        int n = s.length();
        for (int i = 0; i < n; i++) {
            if (S[i] != T[i])
                return false;
        }
        return true;
    }
}