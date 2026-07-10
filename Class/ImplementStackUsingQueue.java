class MyQueue {
    Stack<Integer> stack;
    Stack<Integer> reverseStack;
    public MyQueue() {
        this.stack = new Stack<>();
        this.reverseStack = new Stack<>();
    }
    
    public void push(int x) {
        stack.push(x);
    }
    
    public int pop() {
        if(empty()) {
            return -1;
        }
        if(reverseStack.isEmpty()) {
            // empty stack to reverse
            while(!stack.isEmpty()) {
                reverseStack.push(stack.pop());
            }
        }
        return reverseStack.pop();
    }
    
    public int peek() {
        if(empty()) {
            return -1;
        }
        if(reverseStack.isEmpty()) {
            // empty stack to reverse
            while(!stack.isEmpty()) {
                reverseStack.push(stack.pop());
            }
        }
        return reverseStack.peek();
    }
    
    public boolean empty() {
        if(reverseStack.isEmpty() && stack.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */