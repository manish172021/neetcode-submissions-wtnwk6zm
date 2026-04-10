class Solution {
    public int rob(int[] nums) {
        int[] memo = new int[nums.length];
        return rob(nums, 0, nums.length - 1, memo);
    }

    private int rob(int[] nums, int idx, int end, int[] memo) {
        if(idx > end) {
            return 0;
        }
        if(memo[idx] != 0) return memo[idx];
        if(idx == end) {
            return memo[idx] = nums[idx];
        }
        int op1 = nums[idx] + rob(nums, idx + 2, end, memo);
        int op2 = rob(nums, idx + 1, end, memo);
        return memo[idx] = Math.max(op1, op2);
    }
}
