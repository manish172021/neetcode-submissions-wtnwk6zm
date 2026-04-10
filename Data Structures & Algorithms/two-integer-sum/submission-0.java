class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<nums.length; i++) {
            if(map.containsKey(nums[i]) && 2*nums[i] == target) {
                map.put(nums[i], i);
            }
            else {
                map.put(nums[i], i);
            }
        }
        for(int i=0; i<nums.length; i++) {
            if(map.containsKey(target - nums[i]) && i != map.get(target - nums[i])) {
                return new int[]{i, map.get(target - nums[i])};
            }
        }
        return new int[]{-1, -1};
    }
}
