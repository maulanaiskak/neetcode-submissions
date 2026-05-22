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
        var current = head;
        ListNode reversed = null;

        while (current != null) {
            var next = current.next;
            current.next = reversed;
            reversed = current;
            current = next;
        }

        return reversed;
    }
}
