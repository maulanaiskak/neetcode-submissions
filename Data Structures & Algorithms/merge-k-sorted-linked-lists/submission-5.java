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
        if (lists.length == 0) {
            return null;
        }

        for (var step = 1; step < lists.length; step *= 2) {
            for (var i = 0; i + step < lists.length; i += step * 2) {
                lists[i] = merge(lists[i], lists[i + step]);
            }
        }
        return lists[0];
    }

    private ListNode merge(ListNode list1, ListNode list2) {
        var dummy = new ListNode(0);
        var current = dummy;

        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                current.next = list1;
                list1 = list1.next;
            } else {
                current.next = list2;
                list2 = list2.next;
            }

            current = current.next;
        }

        current.next = list1 != null ? list1 : list2;

        return dummy.next;
    }
}
