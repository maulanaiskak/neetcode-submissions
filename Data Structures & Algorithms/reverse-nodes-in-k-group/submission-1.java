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
        var slow = head;

        for (var i = 1; i < k; i++) {
            if (slow == null) {
                return head;
            }

            slow = slow.next;
        }

        if (slow == null) {
            return head;
        }

        var right = slow.next;
        slow.next = null;

        var left = head;

        var reversedRight = reverseKGroup(right, k);
        var reversedLeft = reverse(left, reversedRight);

        return reversedLeft;
    }

    private ListNode reverse(ListNode head, ListNode initialNode) {
        var current = head;
        ListNode reversed = initialNode;

        while (current != null) {
            var tmp = current.next;
            current.next = reversed;
            reversed = current;
            current = tmp;
        }

        return reversed;
    }
}
