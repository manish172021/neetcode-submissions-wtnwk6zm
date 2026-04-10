class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack();
        for(char c : s.toCharArray()) {
            if(stack.isEmpty()) {
                stack.push(c);
                continue;
            }
            char top = stack.peek();
            if(c == '(' || c == '{' || c == '[') {
                stack.push(c);
            }
            else if(top == '(' && c == ')') {
                stack.pop();
            }
            else if(top == '{' && c == '}') {
                stack.pop();
            }
            else if(top == '[' && c == ']') {
                stack.pop();
            }
            else {
                return false;
            }
        }
        return stack.isEmpty() ? true : false;
    }
}
