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

        return mergeKLists(lists, 0, lists.length - 1);
    }

    private ListNode mergeKLists(ListNode[] lists, int left, int right) {
        if (left == right) {
            return lists[left];
        }

        var mid = (left + right) / 2;

        var leftList = mergeKLists(lists, left, mid);
        var rightList = mergeKLists(lists, mid + 1, right);

        return merge(leftList, rightList);
    }

    private ListNode merge(ListNode list1, ListNode list2) {
        var dummy = new ListNode();
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

        while (list1 != null) {
            current.next = list1;
            list1 = list1.next;
            current = current.next;
        }

        while (list2 != null) {
            current.next = list2;
            list2 = list2.next;
            current = current.next;
        }

        return dummy.next;
    }
}
