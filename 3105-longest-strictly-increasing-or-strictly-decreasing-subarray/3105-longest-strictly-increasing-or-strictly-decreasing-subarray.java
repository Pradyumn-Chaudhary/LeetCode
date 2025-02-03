class Solution {
    public int longestMonotonicSubarray(int[] nums) {
        if (nums.length == 0)
            return 0;
        int in = 1, de = 1;
        int md = 1, mi = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                md = Math.max(md, de);
                mi = Math.max(mi, in);
                de = 1;
                in = 1;
            } else if (nums[i] > nums[i - 1]) {
                in++;
                md = Math.max(md, de);
                de = 1;
            } else {
                de++;
                mi = Math.max(mi, in);
                in = 1;
            }
        }
        md = Math.max(md, de);
        mi = Math.max(mi, in);
        return Math.max(mi, md);
    }
}