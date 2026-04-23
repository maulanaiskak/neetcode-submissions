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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        var carry = 0;
        var result = new ListNode();
        var current = result;

        while (l1 != null || l2 != null) {
            var l1Val = l1 != null ? l1.val : 0;
            var l2Val = l2 != null ? l2.val : 0;
            var sum = carry + l1Val + l2Val;
            carry = sum / 10;
            current.next = new ListNode(sum % 10);
            current = current.next;

            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }

        if (carry > 0) {
            current.next = new ListNode(carry);
        }

        return result.next;
    }
}