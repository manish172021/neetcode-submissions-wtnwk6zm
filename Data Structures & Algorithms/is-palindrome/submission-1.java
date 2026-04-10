class Solution {
    public boolean isPalindrome(String s) {
        StringBuilder str = new StringBuilder();
        for(char c : s.toCharArray()) {
            if(Character.isLetterOrDigit(c)) {
                str.append(c);
            }
        }
        return isPalindromeHelper(str.toString());
    }
    private boolean isPalindromeHelper(String s) {
        int l = 0, r = s.length() - 1;
        while(l < r) {
            if(Character.toLowerCase(s.charAt(l++)) != Character.toLowerCase(s.charAt(r--))) return false;
        }
        return true;
    }
}
