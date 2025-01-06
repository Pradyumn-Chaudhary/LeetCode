class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        int n = nums.length;
        for (int i = 0; i < n - 3; i++) {
            if (i > 0 && nums[i] == nums[i - 1])
                continue;
            for (int j = i + 1; j < n - 2; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1])
                    continue;
                int k = j + 1;
                int z = n - 1;
                while (k < z) {
                    int sum = nums[i] + nums[j] + nums[k] + nums[z];
                    if (sum == target) {
                        list.add(Arrays.asList(nums[i], nums[j], nums[k], nums[z]));
                        k++;
                        z--;
                        while (k < z && nums[k] == nums[k - 1]) {
                            k++;
                        }
                        while (k < z && nums[z] == nums[z + 1]) {
                            z--;
                        }
                    } else if (sum > target) {
                        z--;
                    } else {
                        k++;
                    }
                }
            }
        }
        return list;
    }
}