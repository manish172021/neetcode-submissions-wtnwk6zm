class Solution {
    public List<Integer> partitionLabels(String s) {
        Map<Character, Integer> lastOcuurance = new HashMap<>();
        for(int i=0; i< s.length(); i++) {
            lastOcuurance.put(s.charAt(i), i);
        }
        List<Integer> ans = new ArrayList<>();
        int l = 0, r  = 0;
        int maxIndex = -1; // 3
        while(l < s.length()) {
            boolean canGrow = lastOcuurance.get(s.charAt(r)) > r || lastOcuurance.get(s.charAt(r)) < maxIndex;
            if(canGrow) {
                maxIndex = Math.max(maxIndex, lastOcuurance.get(s.charAt(r)));
                r++;
            }
            else {
                ans.add(r-l+1);
                l = r + 1;
                r = r + 1;
            }
        }
        return ans;
    }
}
