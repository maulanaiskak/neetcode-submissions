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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        var dummy = new ListNode();
        dummy.next = head;

        var first = head;
        for (var i = 0; i < n; i++) {
            if (first != null) {
                first = first.next;
            }
        }

        var second = dummy;
        while (first != null) {
            first = first.next;
            second = second.next;
        }

        var next = second.next;
        second.next = next.next;

        return dummy.next;
    }
}
