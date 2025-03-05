class Solution {
    public int[] findPeakGrid(int[][] mat) {
        int n = mat.length, m = mat[0].length;
        if (m == 1) {
            int row = 0;
            int max = mat[row][0];
            for (int i = 1; i < n; i++) {
                if (mat[i][0] > max) {
                    max = mat[i][0];
                    row = i;
                }
            }
            return new int[] { row, 0 };
        }
        int low = 0, high = m - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            int row = 0;
            int max = mat[row][mid];
            for (int i = 1; i < n; i++) {
                if (mat[i][mid] > max) {
                    row = i;
                    max = mat[row][mid];
                }
            }
            boolean leftOK = (mid == 0 || max > mat[row][mid - 1]);
            boolean rightOK = (mid == m - 1 || max > mat[row][mid + 1]);

            if (leftOK && rightOK) {
                return new int[] { row, mid };
            } else if (mid > 0 && max < mat[row][mid - 1]) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return new int[] { -1, -1 };
    }
}