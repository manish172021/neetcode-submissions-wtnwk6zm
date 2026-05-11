class Solution {

    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        combinationSum(nums, target, 0, new ArrayList<>(), ans);
        return ans;
    }

    private void combinationSum(int[] nums, int target, int idx, List<Integer> outputSoFar, List<List<Integer>> ans) {
        if(target == 0) {
            ans.add(new ArrayList<>(outputSoFar));
            return;
        }
        if(idx >= nums.length) {
            return;
        }
        if(target < 0) {
            return;
        }

        combinationSum(nums, target, idx + 1, outputSoFar, ans);
        outputSoFar.add(nums[idx]);
        combinationSum(nums, target - nums[idx], idx, outputSoFar, ans);
        outputSoFar.remove(outputSoFar.size() - 1);
    }
}
