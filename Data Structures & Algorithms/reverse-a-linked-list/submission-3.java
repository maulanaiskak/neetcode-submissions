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
    public ListNode reverseList(ListNode head) {
        ListNode result = null;
        var current = head;

        while (current != null) {
            var next = current.next;
            current.next = result;
            result = current;
            current = next;
        }

        return result;
    }
}
