class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        // Arrays.sort(candidates);
        // Set<List<Integer>> ans = new HashSet<>();
        // combinationSum2(candidates, target, 0, new ArrayList<>(), ans);
        // return new ArrayList<>(ans);

        Arrays.sort(candidates);
        List<List<Integer>> ans = new ArrayList<>();
        combinationSum2(candidates, target, 0, new ArrayList<>(), ans);
        return ans;

    }


    private void combinationSum2(int[] nums, int target, int idx, List<Integer> outputSoFar, List<List<Integer>> ans) {
        if(target == 0) { // target wala test positive
            ans.add(new ArrayList<>(outputSoFar));
            return;
        }
        if(target < 0) { // target wala test nedative
            return;
        }
        for(int i = idx; i < nums.length; i++) {
            int num = nums[i];

            // skip duplicate that can be made from after
            if(i > idx && nums[i] == nums[i - 1]) {
                continue;
            }

            if(num > target) {
                break;
            }

            outputSoFar.add(num);
            combinationSum2(nums, target - num, i + 1, outputSoFar, ans);
            outputSoFar.remove(outputSoFar.size() - 1);
        }
    }



    // O(2^n⋅klogM)
    // 2^n → all subsets generated
    // k → average size of combination copied into set/list
    // M → number of elements in HashSet (hash/equality comparisons)
    private void combinationSum2(int[] nums, int target, int idx, List<Integer> outputSoFar, Set<List<Integer>> ans) {
        if(target == 0) { // target wala test positive
            ans.add(new ArrayList<>(outputSoFar));
            return;
        }
        if(target < 0) { // target wala test nedative
            return;
        }
        if(idx >= nums.length) { // array wala test
            return;
        }
        combinationSum2(nums, target, idx + 1, outputSoFar, ans);
        outputSoFar.add(nums[idx]);
        combinationSum2(nums, target - nums[idx], idx + 1, outputSoFar, ans);
        outputSoFar.remove(outputSoFar.size() - 1);
    }
}
