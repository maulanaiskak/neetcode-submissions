class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        var current = head;

        for (var i = 0; i < k; i++) {
            if (current == null) {
                return head;
            }

            current = current.next;
        }

        var prev = reverseKGroup(current, k);
        current = head;

        for (var i = 0; i < k; i++) {
            var next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        return prev;
    }
}