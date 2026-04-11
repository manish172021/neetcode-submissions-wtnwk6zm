class Solution {

    public boolean canJump(int[] nums) {
        int maxReachableIdx = 0;

        for (int currIdx = 0; currIdx < nums.length; currIdx++) {
            if (currIdx > maxReachableIdx) {
                return false; // can't reach this index
            }
            maxReachableIdx = Math.max(maxReachableIdx, currIdx + nums[currIdx]);
        }

        return true;
    }




    public boolean canJumpRec(int[] nums) {
        Boolean memo[] = new Boolean[nums.length ];
        return canJump(nums, 0, memo);
    }

    // O(n^2)
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
