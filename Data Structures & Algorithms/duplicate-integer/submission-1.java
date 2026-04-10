class Solution {
    public boolean hasDuplicate(int[] nums) {
        boolean ans = false;
        Set set = new HashSet<>();
        for(int num : nums) {
            if(set.contains(num)) {
               ans =  true;
               break; 
            }
            set.add(num);
        }
        return ans;
    }
}