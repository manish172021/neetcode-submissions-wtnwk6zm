class Solution {


    public boolean canPartition(int[] nums) {
        int totalSum = Arrays.stream(nums).reduce(0, (a, b) -> a + b);
        if(totalSum % 2 != 0) return false;
        int target = totalSum / 2;
        int[][] memo = new int[nums.length + 1][target + 1];
        for(int[] row : memo) Arrays.fill(row, -1);
        return canPartition(nums, 0, target, memo);
    }

    public boolean canPartition(int[] nums, int start, int target, int[][] memo) {
        if(start == nums.length) {
            return target == 0;
        }
        if(memo[start][target] != -1) {
            return memo[start][target] == 0 ? false : true; 
        }
        boolean notInclude = canPartition(nums, start + 1, target, memo);
        boolean include = false;
        if(target >= nums[start]) {
            include = canPartition(nums, start + 1, target - nums[start], memo);
        }
        memo[start][target] = (notInclude || include) == true ? 1 : 0;
        return memo[start][target] == 0 ? false : true;
    }
}
