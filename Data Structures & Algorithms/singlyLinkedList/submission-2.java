public class LinkedList {
    private Node head;
    private int size;

    class Node {
        int value;
        Node next;

        public Node(int value) {
            this.value = value;
            this.next = null;
        }
    }

    public LinkedList() {
        this.head = null;
        this.size = 0;
    }

    public int get(int index) {
        if (index < 0 || index >= this.size) {
            return -1;
        }
        Node current = this.head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current.value;
    }

    public void insertHead(int val) {
        Node newHead = new Node(val);
        newHead.next = this.head;
        this.head = newHead;
        this.size++;
    }

    public void insertTail(int val) {
        Node newTail = new Node(val);
        if (this.head == null) {
            this.head = newTail;
        } else {
            Node current = this.head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newTail;
        }
        this.size++;
    }

    public boolean remove(int index) {
        if (index < 0 || index >= this.size) {
            return false;
        }

        if (index == 0) {
            this.head = this.head.next;
        } else {
            Node current = this.head;
            for (int i = 0; i < index - 1; i++) {
                current = current.next;
            }
            current.next = current.next.next;
        }
        this.size--;
        return true;
    }

    public ArrayList<Integer> getValues() {
        ArrayList<Integer> result = new ArrayList<>();
        Node current = this.head;
        while (current != null) {
            result.add(current.value);
            current = current.next;
        }
        return result;
    }

    public int getSize() {
        return this.size;
    }
}