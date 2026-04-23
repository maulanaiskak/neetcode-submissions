class MinStack {
    ArrayDeque<Integer> data;
    ArrayDeque<Integer> min;

    public MinStack() {
        data = new ArrayDeque<>();
        min = new ArrayDeque<>();
    }
    
    public void push(int val) {
        data.push(val);
        
        if (min.isEmpty() || val <= min.peek()) {
            min.push(val);
        } else {
            min.push(min.peek());
        }
    }
    
    public void pop() {
        if (data.isEmpty()) {
            return;
        }
        
        data.pop();
        min.pop();
    }
    
    public int top() {
        return data.peek();
    }
    
    public int getMin() {
        return min.peek();
    }
}
