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
        var dummy = new ListNode();
        var result = dummy;

        while (l1 != null || l2 != null) {
            var addition = carry;

            if (l1 != null) {
                addition += l1.val;
                l1 = l1.next;
            }

            if (l2 != null) {
                addition += l2.val;
                l2 = l2.next;
            }

            var number = addition % 10;
            carry = addition / 10;

            result.next = new ListNode(number);
            result = result.next;
        }

        if (carry > 0) {
            result.next = new ListNode(carry);
        }

        return dummy.next;
    }
}
