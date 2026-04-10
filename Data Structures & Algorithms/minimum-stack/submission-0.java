class MinStack {
    Stack<Integer> stack;
    Stack<Integer> minStack;
    int currentMin;

    public MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
        currentMin = Integer.MAX_VALUE;
    }
    
    public void push(int val) {
        stack.push(val);
        currentMin = Math.min(val, currentMin);
        minStack.push(currentMin);
    }
    
    public void pop() {
        int poopedMin = minStack.peek();
        stack.pop();
        minStack.pop();
        if(poopedMin == currentMin) {
            if(minStack.empty()) {
                currentMin = Integer.MAX_VALUE;
            }
            else {
                currentMin = minStack.peek();
            }
        }
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return minStack.peek();
    }
}
