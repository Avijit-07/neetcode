class MinStack {
    Stack<Integer> stack;
    Stack<Integer> minStack;

    public MinStack() {
       stack = new Stack<>();
       minStack = new Stack<>();
    }
    
    public void push(int val) {
        stack.push(val);
        if(!minStack.isEmpty()) { 
            int currMin = Math.min(minStack.peek(), val);
            minStack.push(currMin);
        } else {
            minStack.push(val);
        }
    }
    
    public void pop() {
        stack.pop();
        minStack.pop();
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return minStack.peek();
    }
}
