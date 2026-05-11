class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        // Set<List<Integer>> ans = new HashSet<>();
        // Arrays.sort(nums);
        // subsetsWithDup(nums, 0, new ArrayList<Integer>(), ans);
        // return new ArrayList<>(ans);

        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        subsetsWithDup(nums, 0, new ArrayList<Integer>(), ans);
        return ans;
    }


    // O(2^n⋅ n)
    // 2^n → every element has take / not-take possibility
    // k → average size of valid combination copied into answer
    private void subsetsWithDup(int[] nums, int idx, List<Integer> outputSoFar, List<List<Integer>> ans) {
        
        ans.add(new ArrayList<>(outputSoFar));

        for(int i = idx; i < nums.length; i++) {
            int num = nums[i];

            // skip duplicate that can be made from after
            if(i > idx && nums[i] == nums[i - 1]) {
                continue;
            }

            outputSoFar.add(num);
            subsetsWithDup(nums, i + 1, outputSoFar, ans);
            outputSoFar.remove(outputSoFar.size() - 1);
        }
    }


    // Time O(n * 2^n) || space O(2^n)
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
