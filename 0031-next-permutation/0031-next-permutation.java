class Solution {
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        int breakPoint = -1;
        for (int i = n - 1; i > 0; i--) {
            if (nums[i - 1] < nums[i]) {
                breakPoint = i - 1;
                break;
            }
        }
        if (breakPoint == -1) {
            for (int i = 0; i < n / 2; i++) {
                int temp = nums[i];
                nums[i] = nums[n - 1 - i];
                nums[n - 1 - i] = temp;
            }
            return;
        }
        int temp = n - 1;
        for (int i = n - 1; i >= breakPoint + 1; i--) {
            if (nums[i] > nums[breakPoint]) {
                temp = i;
                break;
            }
        }
        int Temp = nums[temp];
        nums[temp] = nums[breakPoint];
        nums[breakPoint] = Temp;

        int i = breakPoint + 1;
        int j = n - 1;
        while (i < j) {
            temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
            i++;
            j--;
        }
    }
}