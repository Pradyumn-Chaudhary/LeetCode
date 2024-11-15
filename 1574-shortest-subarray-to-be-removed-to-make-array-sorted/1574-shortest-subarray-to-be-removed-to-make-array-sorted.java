class Solution {
    public int findLengthOfShortestSubarray(int[] arr) {
        int n = arr.length;
        int low = 0, high = n - 1;

        // Find the left sorted part
        while (low < n - 1 && arr[low] <= arr[low + 1]) {
            low++;
        }
        
        // If the entire array is already sorted
        if (low == n - 1) {
            return 0;
        }

        // Find the right sorted part
        while (high > 0 && arr[high] >= arr[high - 1]) {
            high--;
        }

        // Find the minimum subarray removal
        int minRemoval = Math.min(n - low - 1, high); 

        // Check if merging left and right parts can form a sorted array
        int i = 0, j = high;
        while (i <= low && j < n) {
            if (arr[i] <= arr[j]) {
                minRemoval = Math.min(minRemoval, j - i - 1);
                i++;
            } else {
                j++;
            }
        }
        
        return minRemoval;
    }
}
