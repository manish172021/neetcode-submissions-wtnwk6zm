class Solution {

    public List<List<Integer>> permute(int[] nums) {
        return permute(nums, 0);
    }

    // O(n! . n)
    // for each permuation copying new ArrayList<>(perm) takes o(n)
    // also may shift elements → O(n)
    // and there are n! permuations
    // n! permutations × O(n) work
    private List<List<Integer>> permute(int[] nums, int idx) {

        List<List<Integer>> ans = new ArrayList<>();

        if(idx >= nums.length) {
            List<Integer> temp = new ArrayList<>();
            ans.add(temp);
            return ans;
        }

        List<List<Integer>> smallAns = permute(nums, idx + 1);
        for(List<Integer> perm : smallAns) {
            for(int i = 0; i < perm.size() + 1; i++) {
                List<Integer> newPerm = new ArrayList<>(perm);
                newPerm.add(i, nums[idx]);
                ans.add(newPerm);
            }
        }
        return ans;
    }


}

// 2 3
// 3 2

// 1 2 3
// 2 1 3
// 1 3 1

// 1 3 2
// 3 1 2
// 3 2 1
