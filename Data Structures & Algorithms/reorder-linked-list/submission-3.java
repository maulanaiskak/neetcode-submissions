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
        var slow = head;
        var fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        var right = slow.next;
        ListNode reversedRight = null;

        while (right != null) {
            var next = right.next;
            right.next = reversedRight;
            reversedRight = right;
            right = next;
        }

        slow.next = null;
        var left = head;

        while (reversedRight != null) {
            var nextLeft = left.next;
            var nextRight = reversedRight.next;

            left.next = reversedRight;
            reversedRight.next = nextLeft;

            left = nextLeft;
            reversedRight = nextRight;
        }
    }
}
