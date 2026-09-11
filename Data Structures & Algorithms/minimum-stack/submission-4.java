class MinStack {
    private List<Integer> data;
    private List<Integer> min;

    public MinStack() {
        data = new ArrayList<>();
        min = new ArrayList<>();
    }
    
    public void push(int val) {
        data.add(val);

        if (min.isEmpty()) {
            min.add(val);
        } else {
            min.add(Math.min(val, min.getLast()));
        }
    }
    
    public void pop() {
        data.remove(data.size() - 1);
        min.remove(min.size() - 1);
    }
    
    public int top() {
        return data.getLast();
    }
    
    public int getMin() {
        return min.getLast();
    }
}
