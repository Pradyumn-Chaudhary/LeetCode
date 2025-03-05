class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length, m = matrix[0].length, high = m - 1;
        for (int i = 0; i < n; i++) {
            if (high == -1)
                return false;
            int low = 0;
            while (low <= high) {
                int mid = (low + high) / 2;
                if (matrix[i][mid] == target)
                    return true;
                else if (matrix[i][mid] < target)
                    low = mid + 1;
                else
                    high = mid - 1;
            }
        }
        return false;
    }
}