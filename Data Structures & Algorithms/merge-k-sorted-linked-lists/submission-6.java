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

        var current = new ArrayList<>(Arrays.asList(lists));

        while (current.size() > 1) {
            var next = new ArrayList<ListNode>();

            for (var i = 0; i < current.size(); i += 2) {
                var l1 = current.get(i);
                var l2 = (i + 1 < current.size()) ? current.get(i + 1) : null;
                next.add(merge(l1, l2));
            }

            current = next;
        }

        return current.get(0);
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
