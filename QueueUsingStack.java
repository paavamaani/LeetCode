#https://leetcode.com/problems/implement-queue-using-stacks

class MyQueue {
    private Stack<Integer> stack1;
    private Stack<Integer> stack2;

    public MyQueue() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }
    
    public void push(int x) {
        stack1.push(x);
    }
    
    public void isStackEmpty() {
        if(stack2.isEmpty()) {
           Iterator value = stack1.iterator();

           while(value.hasNext()) {
               stack2.push(stack1.pop());
           }
        }
    }
    
    public int pop() {
        isStackEmpty();
        return stack2.pop();
    }
    
    public int peek() {
        isStackEmpty();
        return stack2.peek();
    }
    
    public boolean empty() {
        return stack1.isEmpty() && stack2.isEmpty();
    }
}
