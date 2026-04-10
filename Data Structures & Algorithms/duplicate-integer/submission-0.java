class Solution {
    public boolean hasDuplicate(int[] nums) {
        boolean ans = false;
        Map<Integer, Boolean> map = new HashMap<>();
        for(int num : nums) {
            if(map.containsKey(num)) {
               ans =  true;
               break; 
            }
            map.put(num, true);
        }
        return ans;
    }
}