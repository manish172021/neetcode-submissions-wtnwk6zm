class Solution {


    public boolean canPartition(int[] nums) {
        int totalSum = Arrays.stream(nums).reduce(0, (a, b) -> a + b);
        if(totalSum % 2 != 0) return false;
        int target = totalSum / 2;
        Boolean[][] memo = new Boolean[nums.length + 1][target + 1];
        return canPartition(nums, 0, target, memo);
    }

    public boolean canPartition(int[] nums, int start, int target, Boolean[][] memo) {
        if(start == nums.length) {
            return target == 0;
        }
        if(memo[start][target] != null) {
            return memo[start][target]; 
        }
        boolean notInclude = canPartition(nums, start + 1, target, memo);
        boolean include = false;
        if(target >= nums[start]) {
            include = canPartition(nums, start + 1, target - nums[start], memo);
        }
        return memo[start][target] = notInclude || include;
    }
}
