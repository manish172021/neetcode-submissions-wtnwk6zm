class Solution {
    public int findMin(int[] nums) {
       int l = 0, r = nums.length - 1;
        int ans = Integer.MAX_VALUE;
        while(l <= r) {
            int mid = l + (r - l) / 2;
            ans = Math.min(ans, nums[mid]);
            if(nums[mid] > nums[l]) {
                if(nums[mid] > nums[r]) {
                    l = mid + 1;
                }
                else {
                    r = mid - 1;
                }
            }
            else {
                if(nums[mid] < nums[l]) {
                    r = mid - 1;
                }
                else {
                    l = mid + 1;
                }
            }
        }
        return ans;
    }
}
