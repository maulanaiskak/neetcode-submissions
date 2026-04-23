/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        var map = new HashMap<Node, Node>();
        var originalCurrent = head;

        while (originalCurrent != null) {
            map.put(originalCurrent, new Node(originalCurrent.val));
            originalCurrent = originalCurrent.next;
        }

        originalCurrent = head;

        while (originalCurrent != null) {
            var copiedNode = map.get(originalCurrent);
            copiedNode.next = map.get(originalCurrent.next);
            copiedNode.random = map.get(originalCurrent.random);
            originalCurrent = originalCurrent.next;
        }

        return map.get(head);
    }
}