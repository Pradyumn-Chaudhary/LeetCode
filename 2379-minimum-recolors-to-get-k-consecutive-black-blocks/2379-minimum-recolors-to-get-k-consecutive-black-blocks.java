class Solution {
    public int minimumRecolors(String b, int k) {
        int n = b.length();
        int j = k - 1;
        int w = 0;
        int operation = 0;
        for(int i = 0;i < k;i++){
            if(b.charAt(i) == 'W')
                w++;
        }
        operation = w;
        for(int i = 1;i < n - k + 1;i++){
            if(b.charAt(i-1) == 'W')
                w--;
            if(b.charAt(i + k - 1) == 'W')
                w++;
            operation = Math.min(operation,w);
        }
        return operation;
    }
}