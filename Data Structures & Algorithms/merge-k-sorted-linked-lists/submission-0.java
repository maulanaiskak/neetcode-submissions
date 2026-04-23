/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        var minHeap = new PriorityQueue<ListNode>((a, b) -> Integer.compare(a.val, b.val));
        
        for (var list : lists) {
            if (list != null) {
                minHeap.add(list);
            }
        }

        var result = new ListNode(0);
        var current = result;

        while (!minHeap.isEmpty()) {
            var smallest = minHeap.poll();
            current.next = smallest;
            current = current.next;

            if (smallest.next != null) {
                minHeap.add(smallest.next);
            }
        }

        return result.next;
    }
}
