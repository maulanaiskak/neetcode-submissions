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
    public ListNode reverseKGroup(ListNode head, int k) {
        if (!isValid(head, k)) {
            return head;
        }

        var nodes = reverse(head, k);
        var reversed = nodes[0];
        var remaining = nodes[1];

        head.next = reverseKGroup(remaining, k);

        return reversed;
    }

    private boolean isValid(ListNode head, int k) {
        var current = head;
        var count = 0;

        while (current != null && count++ < k) {
            current = current.next;
        }
        return count >= k;
    }

    private ListNode[] reverse(ListNode head, int k) {
        var current = head;
        ListNode reversed = null;
        var count = 0;

        while (current != null && count < k) {
            var next = current.next;
            current.next = reversed;
            reversed = current;
            current = next;
            count++;
        }

        return new ListNode[]{reversed, current};
    }
}
