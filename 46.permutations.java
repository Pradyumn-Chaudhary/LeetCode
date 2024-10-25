import java.util.*;
/*
 * @lc app=leetcode id=46 lang=java
 *
 * [46] Permutations
 */

// @lc code=start
class Solution {
    public void helper(int[] nums,List<List<Integer>> allset,List<Integer> set) {
        if (nums.length == set.size()) {
            allset.add(new ArrayList<>(set));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
           if (set.contains(nums[i]))
               continue;
           set.add(nums[i]);
           helper(nums, allset, set);
           set.remove(set.size()-1);
        }
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> allset = new ArrayList<>();
        helper(nums, allset, new ArrayList<>());
        return allset;
    }
}
// @lc code=end

