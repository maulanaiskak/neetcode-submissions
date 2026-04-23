class DynamicArray {
    private int[] array;
    private int size;
    private int capacity;

    public DynamicArray(int capacity) {
        this.array = new int[capacity];
        this.size = 0;
        this.capacity = capacity;
    }

    public int get(int i) {
        return array[i];
    }

    public void set(int i, int n) {
        this.array[i] = n;
    }

    public void pushback(int n) {
        if (this.size == this.capacity) {
            resize();
        }
        this.array[this.size] = n;
        this.size++;
    }

    public int popback() {
        if (this.size > 0) {
            this.size--;
        }
        return this.array[this.size];
    }

    private void resize() {
        this.capacity = this.array.length * 2;
        var newArray = new int[this.capacity];

        for (var i = 0; i < this.size; i++) {
            newArray[i] = this.array[i];
        }

        this.array = newArray;
    }

    public int getSize() {
        return this.size;
    }

    public int getCapacity() {
        return this.capacity;
    }
}
