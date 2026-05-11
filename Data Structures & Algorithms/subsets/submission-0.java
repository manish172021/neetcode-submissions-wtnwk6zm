class Solution {

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        subsets(nums, 0, new ArrayList<Integer>(), ans);
        return ans;
    }

    private void subsets(int[] nums, int idx, List<Integer> smallAns ,List<List<Integer>> ans) {
        if(idx == nums.length) {
            ans.add(new ArrayList<>(smallAns));
            return;
        }
        subsets(nums, idx + 1, smallAns, ans);
        smallAns.add(nums[idx]);
        subsets(nums, idx + 1, smallAns, ans);
        smallAns.remove(smallAns.size()-1);
    }



}
