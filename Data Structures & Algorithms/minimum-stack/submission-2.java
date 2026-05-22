class MinStack {
    List<Integer> data;
    List<Integer> minData;

    public MinStack() {
        data = new ArrayList<>();
        minData = new ArrayList<>();
    }
    
    public void push(int val) {
        data.add(val);

        if (minData.isEmpty()) {
            minData.add(val);
        } else {
            minData.add(Math.min(minData.get(minData.size() - 1), val));
        }
    }
    
    public void pop() {
        data.remove(data.size() - 1);
        minData.remove(minData.size() - 1);
    }
    
    public int top() {
        return data.get(data.size() - 1);
    }
    
    public int getMin() {
        return minData.get(data.size() - 1);
    }
}
