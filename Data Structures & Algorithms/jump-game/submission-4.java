class Solution {

    public boolean canJump(int[] nums) {
        Boolean memo[] = new Boolean[nums.length ];
        return canJump(nums, 0, memo);
    }

    private boolean canJump(int[] nums, int start, Boolean memo[]) {
        if (start >= nums.length - 1) {
            return true;
        }
        if(memo[start] != null) {
            return memo[start];
        }

        int maxJump = nums[start];

        for(int i=1; i<=maxJump; i++) {
            int jumpIdx = start + i;

            if(jumpIdx < nums.length && canJump(nums, jumpIdx, memo)) {
                return memo[start] = true;
            }
        }
        return memo[start] = false;
    }
}
