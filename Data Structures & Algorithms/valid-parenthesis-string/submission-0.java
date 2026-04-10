class Solution {
    public boolean checkValidString(String s) {
        return checkValidString(s, 0);
    }
    public boolean checkValidString(String s, int open) {
        if(open < 0) return false;
        if(s.length() == 0) return open == 0;
        if(s.charAt(0) == '(') {
            return checkValidString(s.substring(1), open + 1);
        }
        if(s.charAt(0) == ')') {
            return checkValidString(s.substring(1), open - 1);
        }
        return checkValidString(s.substring(1), open + 1) 
        || checkValidString(s.substring(1), open) 
        || checkValidString(s.substring(1), open - 1);
    }
}
