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
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) return;

        var slow = head;
        var fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        var secondHalf = slow.next;
        slow.next = null;

        ListNode reversedRight = null;
        var current = secondHalf;

        while (current != null) {
            var temp = current.next;
            current.next = reversedRight;
            reversedRight = current;
            current = temp;
        }

        var left = head;
        var right = reversedRight;

        while (right != null) {
            var leftNext = left.next;
            var rightNext = right.next;

            left.next = right;
            right.next = leftNext;

            left = leftNext;
            right = rightNext;
        }
    }
}
