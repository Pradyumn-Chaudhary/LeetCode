class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length;
        int m = matrix[0].length;
        int t = -1;
        while (t++ < n - 1) {
            int low = 0;
            int high = m - 1;
            if (matrix[t][low] > target) {
                return false;
            } else if (matrix[t][high] < target) {
                continue;
            }
            while (low <= high) {
                int mid = (low + high) / 2;
                if (matrix[t][mid] == target) {
                    return true;
                } else if (matrix[t][mid] < target) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }
        return false;
    }
}