class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Set<List<Integer>> ans = new HashSet<>();
        Arrays.sort(nums);
        subsetsWithDup(nums, 0, new ArrayList<Integer>(), ans);
        return new ArrayList<>(ans);
    }


    // Time O(n * 2^n) || space O(n * 2^n)
    private void subsetsWithDup(int[] nums, int idx, List<Integer> outputSoFar, Set<List<Integer>> ans) {
        if(idx >= nums.length) {
            ans.add(new ArrayList<>(outputSoFar));
            return;
        }
        subsetsWithDup(nums, idx + 1, outputSoFar, ans);
        outputSoFar.add(nums[idx]);
        subsetsWithDup(nums, idx + 1, outputSoFar, ans);
        outputSoFar.remove(outputSoFar.size()-1);
    }
}
