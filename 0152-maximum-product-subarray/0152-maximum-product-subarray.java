class Solution {
    public int maxProduct(int[] nums) {
        int MaxProduct = nums[0];
        int prefix = 1, suffix = 1;
        for (int i = 0; i < nums.length; i++) {
            prefix *= nums[i];
            suffix *= nums[nums.length - 1 - i];
            MaxProduct = Math.max(MaxProduct, Math.max(prefix, suffix));

            if (prefix == 0)
                prefix = 1;
            if (suffix == 0)
                suffix = 1;
        }
        return MaxProduct;
    }
}