class MinStack {
    private final List<Integer> data;
    private final List<Integer> min;

    public MinStack() {
        data = new ArrayList<Integer>();
        min = new ArrayList<Integer>();
    }
    
    public void push(int val) {
        data.add(val);

        if (min.size() > 0) {
            min.add(Math.min(val, min.get(min.size() - 1)));
        } else {
            min.add(val);
        }
    }
    
    public void pop() {
        if (data.size() > 0) {
            data.remove(data.size() - 1);
            min.remove(min.size() - 1);
        }
    }
    
    public int top() {
        return data.get(data.size() - 1);
    }
    
    public int getMin() {
        return min.get(min.size() - 1);
    }
}
