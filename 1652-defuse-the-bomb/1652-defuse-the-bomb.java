class Solution {
    public int[] decrypt(int[] code, int k) {
        int n = code.length;
        int[] arr = new int[n];

        // If k is 0, all elements in arr should be 0
        if (k == 0) {
            return arr; // Array is already initialized with zeros
        }

        // Calculate for k > 0
        if (k > 0) {
            for (int i = 0; i < n; i++) {
                int sum = 0;
                for (int j = 1; j <= k; j++) {
                    sum += code[(i + j) % n];
                }
                arr[i] = sum;
            }
        }
        // Calculate for k < 0
        else {
            for (int i = 0; i < n; i++) {
                int sum = 0;
                for (int j = 1; j <= -k; j++) {
                    sum += code[(i - j + n) % n];
                }
                arr[i] = sum;
            }
        }

        return arr;
    }

    // Main method to test the function
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] code = {5, 7, 1, 4};
        int k = 3;
        int[] decrypted = sol.decrypt(code, k);

        for (int num : decrypted) {
            System.out.print(num + " ");
        }
        // Expected Output for k = 3: [12, 10, 16, 13]
    }
}
