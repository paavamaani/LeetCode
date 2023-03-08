#https://leetcode.com/problems/min-stack

class MinStack {
    private int minValue;
    private Stack<Integer> stack;

    public MinStack() {
        this.stack = new Stack<>();
        this.minValue = Integer.MAX_VALUE;
        this.stack.push(minValue);
    }
    
    public void push(int val) {
        if(minValue >= val) {
            stack.push(minValue);

            minValue = val;
        }

        stack.push(val);
    }
    
    public void pop() {
        int top = stack.pop();

        if(top == this.minValue) {
            minValue = stack.pop();
        }
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return this.minValue;
    }
}
