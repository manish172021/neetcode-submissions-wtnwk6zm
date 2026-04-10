class Solution {
    public String longestPalindrome(String s) {
        String ans = "";
        for(int i=0; i<s.length(); i++) {
            int current1 = extandIndex1(s, i);
            int current2 = extandIndex2(s, i);
            String curr1 = s.substring(i - current1, i + current1 + 1);
            String curr2 = s.substring(i - current2, i + current2);
            if(curr1.length() > ans.length()) {
                ans = curr1;
            }
            if(curr2.length() > ans.length()) {
                ans = curr2;
            }
        }
        return ans;
    }

    private int extandIndex1(String s, int index) {
        int l = index - 1, r = index + 1, n = s.length();
        int ans = 0;
        while(l >= 0 && r < n) {
            if(s.charAt(l) == s.charAt(r)) {
                ans++;
                l--;
                r++;
            }
            else {
                break;
            }
        }
       return ans;
    }
    private int extandIndex2(String s, int index) {
        int l = index - 1, r = index, n = s.length();
        int ans = 0;
        while(l >= 0 && r < n) {
            if(s.charAt(l) == s.charAt(r)) {
                ans++;
                l--;
                r++;
            }
            else {
                break;
            }
        }
        return ans;
    }
}
