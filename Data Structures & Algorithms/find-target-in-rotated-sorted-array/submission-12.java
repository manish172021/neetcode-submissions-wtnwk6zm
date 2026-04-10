class Solution {
    public int search(int[] nums, int target) {

        int left = 0;
        int right = nums.length - 1;
        // nums=[1,3]
        // target=3
        while(left <= right) {
            int mid = left + (right - left)/2;
            if(nums[mid] == target) return mid;
            System.out.println("sa" + mid);
            // 3,4,5,6,1,2
            if(nums[left] <= nums[mid]) { // left sorted
                // 1 < 3
                if(target >= nums[left] && target < nums[mid]) {
                   right = mid - 1;
                }
                else {
                    left = mid + 1;
                }
            }
            else { // right sorted
                if(target > nums[mid] && target <= nums[right]) {
                    left = mid + 1;
                }
                else {
                    right = mid - 1;
                }
            }

        }
        return -1;


    }
}
