class Solution {

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        subsets(nums, 0, new ArrayList<Integer>(), ans);
        return ans;
    }

    // Time O(n * 2^n) || space O(n * 2^n)
    private void subsets(int[] nums, int idx, List<Integer> outputSoFar, List<List<Integer>> ans) {
        if(idx >= nums.length) {
            ans.add(new ArrayList<>(outputSoFar));
            return;
        }
        subsets(nums, idx + 1, outputSoFar, ans);
        outputSoFar.add(nums[idx]);
        subsets(nums, idx + 1, outputSoFar, ans);
        outputSoFar.remove(outputSoFar.size()-1);
    }



}
