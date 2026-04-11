class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int[] ans = new int[2];
        int left = 0, right = numbers.length - 1;
        while(left < right) {
            // left Move
            if(numbers[left] + numbers[right] < target) {
                left++;
            }
            else if(numbers[left] + numbers[right] > target) {
                right--;
            }
            else {
                ans = new int[]{left + 1, right + 1};
                return ans;
            }
        }
        return ans;
    }
}
