class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        int n = grid.length;
        long s = 0,s2 = 0;
        for(int i = 0;i<grid.length;i++){
            for(int j = 0;j < grid.length;j++){
                s += grid[i][j];
                s2 += (long)(Math.pow(grid[i][j],2));
            }
        }
        long m = n * n;
        long sn = ((m)*(m + 1)) / 2;
        long s2n = (sn * ((2 * m) + 1)) / 3;
        long msr = sn - s;
        long mpr = (s2n - s2) / msr;
        long missing = (msr + mpr) / 2;
        long repeat = mpr - missing;
        return new int[]{(int)repeat,(int)missing};
    }
}